package ajbc.webservice.rest.CatalogService.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

/**
 * ExceptionMapper contract for a provider that maps Java exceptions to Response.
 * In case of error throws error message on the HTTP server in a JSON template.
 * General -> its one type of this mapper exceptions.
 * @author Faraj 
 *
 */
public class GeneralExceptionMapper implements ExceptionMapper<Throwable>
{
	@Override
	public Response toResponse(Throwable exception) 
	{
		return Response.status(Status.NOT_FOUND)
				.entity(exception.getMessage()).build();
	}
}
