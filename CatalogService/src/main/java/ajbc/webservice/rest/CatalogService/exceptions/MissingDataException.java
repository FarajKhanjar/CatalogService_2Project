package ajbc.webservice.rest.CatalogService.exceptions;

public class MissingDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2584544875645155875L;
	
	public MissingDataException(String errorMessage) 
	{
		super(errorMessage);
	}

}
