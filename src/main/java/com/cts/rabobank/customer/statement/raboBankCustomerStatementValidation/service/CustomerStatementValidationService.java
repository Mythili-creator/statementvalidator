package com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.service;

import com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.exception.JsonErrorFormatException;
import com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.model.ResultantResponse;
import com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.model.StatementDetails;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.contants.Constants.*;

@Service
@Slf4j
public class CustomerStatementValidationService {

//    @Value("${file}")
//    private String path=null;

    public ResultantResponse validation(MultipartFile file) {
        log.info("Inside Service");
        ObjectMapper objectMapper = new ObjectMapper();
        List<StatementDetails> resultForReference = new ArrayList<>();
        List<StatementDetails> incorrectBalance =new ArrayList<>();
        List<String> temporaryCheck = new ArrayList<>();
        try {
            String content = new String(file.getBytes(), StandardCharsets.UTF_8);
            log.info(content);
            List<StatementDetails> customer = objectMapper.readValue(content,
                    new TypeReference<List<StatementDetails>>() {
                    });
            for (StatementDetails statement : customer) {
                if (!temporaryCheck.contains(statement.getReference())) {
                    temporaryCheck.add(statement.getReference());
                } else {
                    resultForReference.add(statement);
                }
                if(0!=new BigDecimal(statement.getEndBalance()).compareTo
                        (new BigDecimal(statement.getStartBalance()).add(new BigDecimal(statement.getMutation()))))
                    incorrectBalance.add(statement);
            }
            log.info("result1"+incorrectBalance);
            log.info("result2" + resultForReference);
            if(resultForReference.isEmpty()&&incorrectBalance.isEmpty())
                return new ResultantResponse(result1,resultForReference.toString());
            else if(incorrectBalance.isEmpty())
                return new ResultantResponse(result2,resultForReference.toString());
            else if(resultForReference.isEmpty())
                return new ResultantResponse(result3,incorrectBalance.toString());
            else
                return new ResultantResponse(result4,
                        resultForReference.toString()+incorrectBalance.toString());
        } catch (Exception e) {
                log.info(""+e);
                throw new JsonErrorFormatException();
        }
    }
}


