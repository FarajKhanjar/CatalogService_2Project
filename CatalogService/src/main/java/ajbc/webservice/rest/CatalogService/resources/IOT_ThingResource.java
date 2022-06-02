package ajbc.webservice.rest.CatalogService.resources;

import java.util.List;
import java.util.UUID;

import ajbc.webservice.rest.CatalogService.DBService.DBService;
import ajbc.webservice.rest.CatalogService.models.IOT_Thing;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("IOTthings")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IOT_ThingResource 
{
	DBService iotDBservice = new DBService();
	
	@GET
	public List<IOT_Thing> getAllIOTThings() 
	{

		return iotDBservice.getAllIOTThings();
	}
	
	@GET
	@Path("/{ID}")
	public IOT_Thing getIOTThingByID(@PathParam("ID") UUID ID) 
	{
		return iotDBservice.getIOTThingByID(ID);
	}
	
	//get IOT-Things by... 
	

}
