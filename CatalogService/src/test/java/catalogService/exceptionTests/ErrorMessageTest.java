package catalogService.exceptionTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ajbc.webservice.rest.CatalogService.exceptions.ErrorMessage;
import ajbc.webservice.rest.CatalogService.exceptions.enums.InternalErrorCode;

class ErrorMessageTest 
{
	ErrorMessage errorMessage;
	String docsLink = "farajkhanjar@gmail.com";
	String viewMsg = "There is not any equal [IOT_thing] to this properties in DB.";

	InternalErrorCode errorCode = InternalErrorCode.NOT_FOUND;
	
	ErrorMessageTest()
	{
		errorMessage = new ErrorMessage(viewMsg, docsLink, InternalErrorCode.NOT_FOUND);
	}
	
	@Test
	void testErrorMsg() 
	{
		assertTrue(errorMessage.getErrorMessage().equals(viewMsg));
		assertTrue(errorMessage.getErrorCode().equals(errorCode));
		assertTrue(errorMessage.getDocsLink().equals(docsLink));
	}

}
