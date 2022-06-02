package ajbc.webservice.rest.CatalogService.resources;

import java.util.List;
import java.util.UUID;

import ajbc.webservice.rest.CatalogService.DBService.DBService;
import ajbc.webservice.rest.CatalogService.models.Device;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


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
		
		//get Device by... 
		

}
