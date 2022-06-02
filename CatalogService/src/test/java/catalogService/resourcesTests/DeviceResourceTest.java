package catalogService.resourcesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import ajbc.webservice.rest.CatalogService.DBService.DBService;
import ajbc.webservice.rest.CatalogService.resources.DeviceResource;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class DeviceResourceTest 
{
	private DeviceResource resource;
	private DBService service;
	
	DeviceResourceTest()
	{
		this.resource  = new DeviceResource();
		this.service = new DBService();
	}
		
	@Test
	void getAllDevicesTest() 
	{
		Response actual = (Response) resource.getAllDevices();
		assertEquals(Status.ACCEPTED.getStatusCode(), actual.getStatus());
	}
	


}
