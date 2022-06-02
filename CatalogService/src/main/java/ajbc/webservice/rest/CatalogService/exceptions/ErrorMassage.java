package ajbc.webservice.rest.CatalogService.exceptions;

import ajbc.webservice.rest.CatalogService.exceptions.enums.InternalErrorCode;

public class ErrorMassage 
{
	private String errMes;
	private InternalErrorCode errorCode;
	private String docsLink;
	
	public ErrorMassage(String errorMessage, String docsLink, InternalErrorCode errorCode) 
	{
		super();
		this.errMes = errorMessage;
		this.errorCode = errorCode;
		this.docsLink = docsLink;
		
	}

	public String getErrorMessage() 
	{
		return errMes;
	}


	public void setErrorMessage(String errorMessage) 
	{
		this.errMes = errorMessage;
	}


	public InternalErrorCode getErrorCode() 
	{
		return errorCode;
	}


	public void setErrorCode(InternalErrorCode errorCode) 
	{
		this.errorCode = errorCode;
	}


	public String getDocsLink() 
	{
		return docsLink;
	}


	public void setDocsLink(String docsLink) 
	{
		this.docsLink = docsLink;
	}
}