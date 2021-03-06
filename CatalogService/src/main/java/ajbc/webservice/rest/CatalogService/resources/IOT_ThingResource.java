package ajbc.webservice.rest.CatalogService.resources;

import java.util.List;
import java.util.UUID;

import ajbc.webservice.rest.CatalogService.DBService.DBService;
import ajbc.webservice.rest.CatalogService.beans.IOTThingFilterBean;
import ajbc.webservice.rest.CatalogService.models.IOT_Thing;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * The IOT_ThingResource sends from the DB current IOTthings and info about it,
 * like get value or list by ID or any other properties.
 */
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
	
	@Path("/{ID}/devices")
	public DeviceResource getDeviceResource() 
	{
		return new DeviceResource();
	}
	
	
	@GET
	@Path("/iotFiltering")
	public Response getIOTThingByProperties(@BeanParam IOTThingFilterBean iotThingFilterBean) 
	{
		IOT_Thing currentIOTthing = iotDBservice.getIOTThingByProperties(
				iotThingFilterBean.getHardwareType(),
				iotThingFilterBean.getModle(),
				iotThingFilterBean.getManufacturer());
		Status status = Status.OK;
		return Response.status(status).entity(currentIOTthing).build();
	}
	

/*
	@GET
	@Path("/getIot")
	public List<IOT_Thing> getIOT_ThingByDevicesId(@PathParam("ID") UUID ID){
		return iotDBservice.getIOTthingByDevicesId(ID);
	}
*/

}
