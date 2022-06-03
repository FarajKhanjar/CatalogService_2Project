package ajbc.webservice.rest.CatalogService.exceptions;

import ajbc.webservice.rest.CatalogService.exceptions.enums.InternalErrorCode;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * 
 * ExceptionMapper contract for a provider that maps Java exceptions to Response.
 * In case of error throws error message on the HTTP server in a JSON template.
 * MissingData -> its one type of this mapper exceptions. in case that a value not available.
 * @author Faraj 
 *
 */
@Provider
public class MissingDataExceptionMapper implements ExceptionMapper<MissingDataException>
{

	@Override
	public Response toResponse(MissingDataException exception) 
	{
		ErrorMessage errMessage = new ErrorMessage(exception.getMessage(), "farajkhanjar@gmail.com",  InternalErrorCode.INVALID_ID);
		return Response.status(Status.NOT_FOUND).entity(errMessage).build();
	}


}