package com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.controller;


import com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.model.ResultantResponse;
import com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.service.CustomerStatementValidationService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@Slf4j
public class CustomerStatementValidationController {

    @Autowired
    private CustomerStatementValidationService validationService = null;

    @PostMapping("/")
    @ApiOperation(value= "Validate the customer statement")
    public ResultantResponse validation(@RequestParam("file") MultipartFile file)  {
        log.info("Inside Controller");
        return  validationService.validation(file);

    }
}
