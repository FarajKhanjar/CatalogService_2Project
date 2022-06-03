package ajbc.webservice.rest.CatalogService.resources;

import java.util.List;
import java.util.UUID;

import ajbc.webservice.rest.CatalogService.DBService.DBService;
import ajbc.webservice.rest.CatalogService.beans.DeviceFilterBeans;
import ajbc.webservice.rest.CatalogService.models.Device;
import ajbc.webservice.rest.CatalogService.models.HardwareType;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * The DeviceResource sends from the DB current devices and info,
 * like get value or list by ID or any other properties.
 */
@Path("devices")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DeviceResource 
{
		DBService deviceDBservice = new DBService();
		
		@GET
		public List<Device> getAllDevices() 
		{

			return deviceDBservice.getAllDevices();
		}
		
		@GET
		@Path("/{ID}")
		public Device getDeviceByID(@PathParam("ID") UUID ID) 
		{
			return deviceDBservice.getDeviceByID(ID);
		}
		
 
		@GET
		@Path("/getDevice")
		public List<Device> getDevicesByIOTthingId(@PathParam("ID") UUID ID)
		{
			return deviceDBservice.getDevicesByIOTthingId(ID);
			
		}
		
		@GET
		@Path("/deviceFiltering")
		public Response getDevicesByProperties(@BeanParam DeviceFilterBeans DeviceFilterBea) 
		{
			Device currentDevice = deviceDBservice.getDevicesByProperties(
					DeviceFilterBea.getHardwareType(),DeviceFilterBea.getModel(),
					DeviceFilterBea.getManufacturer());
			Status status = Status.OK;
			return Response.status(status).entity(currentDevice).build();
		}
		
		
		@GET
		@Path("/getByType")
		public List<Device> getDevicesByType(@QueryParam("hardwareType") HardwareType hardwareType)
		{
				return deviceDBservice.getDevicesByType(hardwareType);
		}
		

/*		@Path("/{ID}/IOTthings")
		public IOT_ThingResource getIOT_ThingResource() 
		{
			return new IOT_ThingResource();
		}
*/
}