package ajbc.webservice.rest.CatalogService.exceptions;

public class NotMatchingDataException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3351586748576879027L;

	public NotMatchingDataException(String errorMessage) 
	{
		super(errorMessage);
	}

}