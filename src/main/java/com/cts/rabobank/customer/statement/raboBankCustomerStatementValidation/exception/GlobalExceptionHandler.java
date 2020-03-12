package com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.exception;

import com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.model.ResultantResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.contants.Constants.result5;
import static com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.contants.Constants.result6;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JsonErrorFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultantResponse handleJsonErrorFormatException(final JsonErrorFormatException ex) {
        return new ResultantResponse(result5, "[]");
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ResultantResponse handleThrowable(final Throwable ex) {
        log.error("Unexpected error", ex);
        return new ResultantResponse( result6,"[]");
    }
}
