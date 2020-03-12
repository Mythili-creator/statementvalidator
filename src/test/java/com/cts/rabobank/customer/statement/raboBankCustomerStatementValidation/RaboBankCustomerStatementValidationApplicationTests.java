package com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation;


import com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.exception.JsonErrorFormatException;

import com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.model.ResultantResponse;
import com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.service.CustomerStatementValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;

import static com.cts.rabobank.customer.statement.raboBankCustomerStatementValidation.contants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class RaboBankCustomerStatementValidationApplicationTests {

	private CustomerStatementValidationService service = new CustomerStatementValidationService();

	@Test
	public void testValidationWithoutValidFile(){
		MultipartFile file=null;
		assertThrows(JsonErrorFormatException.class,()->{
			service.validation(file);
		});
	}

	@Test
	public void testValidationWithValidFile(){
		try {
			MultipartFile multipartFile = new MockMultipartFile("records - test1.json",
					new FileInputStream(new File("C:/Users/803910/Desktop/Assignment/raboBankCustomerStatementValidation/src/main/resources/records - test1.json")));
			ResultantResponse response =service.validation(multipartFile);
			assertEquals(result1,response.result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	@Test
	public void testValidationWithValidFileWithDuplicate(){
		try {
			MultipartFile multipartFile = new MockMultipartFile("records - test2.json",
					new FileInputStream(new File("C:/Users/803910/Desktop/Assignment/raboBankCustomerStatementValidation/src/main/resources/records - test2.json")));
			ResultantResponse response =service.validation(multipartFile);
			assertEquals(result2,response.result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	@Test
	public void testValidationWithValidFileWithReference(){
		try {
			MultipartFile multipartFile = new MockMultipartFile("records - test3.json",
					new FileInputStream(new File("C:/Users/803910/Desktop/Assignment/raboBankCustomerStatementValidation/src/main/resources/records - test3.json")));
			ResultantResponse response =service.validation(multipartFile);
			assertEquals(result3,response.result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testValidationWithValidFileWithBoth(){
		try {
			MultipartFile multipartFile = new MockMultipartFile("records - test4.json",
					new FileInputStream(new File("C:/Users/803910/Desktop/Assignment/raboBankCustomerStatementValidation/src/main/resources/records - test4.json")));
			ResultantResponse response =service.validation(multipartFile);
			assertEquals(result4,response.result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


}
