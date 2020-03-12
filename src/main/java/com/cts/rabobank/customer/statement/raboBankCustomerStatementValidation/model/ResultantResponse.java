package com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.model;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class ResultantResponse {
    public String result;
    public String  errorRecords;

    @Override
    public String toString() {
        return "{" +
                "result='" + result + '\'' +
                ", errorRecords='" + errorRecords + '\'' +'\n'+
                '}';
    }
}
