package com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RaboBankCustomerStatementValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaboBankCustomerStatementValidationApplication.class, args);
		log.info("Main Application");
	}

}
