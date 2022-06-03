package ajbc.webservice.rest.CatalogService.exceptions;

/**
 * In case of error throws error message on the console, extends RuntimeException.
 * in case that data is missing from the basic DB.
 * @author Faraj 
 */
public class MissingDataException extends RuntimeException 
{

	private static final long serialVersionUID = 2584544875645155875L;
	
	public MissingDataException(String errorMessage) 
	{
		super(errorMessage);
	}

}
