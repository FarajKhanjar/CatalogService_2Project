package ajbc.webservice.rest.CatalogService.exceptions;

/**
 * In case of error throws error message on the console, extends RuntimeException.
 * in case that a value doesn't match any fields value in DB.
 * @author Faraj 
 */
public class NotMatchingDataException extends RuntimeException 
{
	private static final long serialVersionUID = 3351586748576879027L;

	public NotMatchingDataException(String errorMessage) 
	{
		super(errorMessage);
	}

}