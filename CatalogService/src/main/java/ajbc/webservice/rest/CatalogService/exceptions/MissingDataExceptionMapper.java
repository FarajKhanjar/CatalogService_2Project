package ajbc.webservice.rest.CatalogService.exceptions;

import ajbc.webservice.rest.CatalogService.exceptions.enums.InternalErrorCode;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

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