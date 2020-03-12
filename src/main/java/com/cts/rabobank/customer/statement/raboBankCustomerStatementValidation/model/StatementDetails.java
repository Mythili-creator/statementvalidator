package com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementDetails {
    @JsonProperty("Reference")
    private String reference;
    @JsonProperty("AccountNumber")
    private String accountNumber;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Start Balance")
    private String startBalance;
    @JsonProperty("Mutation")
    private String mutation;
    @JsonProperty("End Balance")
    private String endBalance;

    @Override
    public String toString() {
        return "{" +
                "reference='" + reference + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
