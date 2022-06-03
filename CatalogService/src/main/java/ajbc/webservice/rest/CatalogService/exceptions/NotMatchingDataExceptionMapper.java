package ajbc.webservice.rest.CatalogService.exceptions;

import ajbc.webservice.rest.CatalogService.exceptions.enums.InternalErrorCode;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * ExceptionMapper contract for a provider that maps Java exceptions to Response.
 * In case of error throws error message on the HTTP server in a JSON template.
 * NotMatchingData -> its one type of mapper exceptions,
 * in case that a value after searching doesn't match any fields value.
 * @author Faraj 
 */
@Provider
public class NotMatchingDataExceptionMapper implements ExceptionMapper<NotMatchingDataException>
{
	@Override
	public Response toResponse(NotMatchingDataException e) 
	{
		ErrorMessage errorMessage = new ErrorMessage(
				e.getMessage(), "farajkhanjar@gmail.com", InternalErrorCode.UNMATCHED_DATA);
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}
}