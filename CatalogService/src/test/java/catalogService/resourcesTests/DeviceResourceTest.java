package catalogService.resourcesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import ajbc.webservice.rest.CatalogService.DBService.DBService;
import ajbc.webservice.rest.CatalogService.DataBase.DBMock;
import ajbc.webservice.rest.CatalogService.exceptions.MissingDataException;
import ajbc.webservice.rest.CatalogService.models.Device;

public class DeviceResourceTest 
{
	private DBService myService = new DBService();
	private DBMock myDB = DBMock.getInstance();
	
	@Test
	public void getAllDevicesTest()
	{
		List<Device> devicesOfService = myService.getAllDevices();
		List<Device> devicesOfDB = myDB.getDevices().values().stream().toList();
		assertEquals(devicesOfDB, devicesOfService);
		
	}
	
	@Test
	public void getDeviceByIdTest()
	{
		List<UUID> listOfId = myDB.getDevices().keySet().stream().toList();
		UUID currentId = listOfId.get(0);
		Device devicesOfService = myService.getDeviceByID(currentId);
		Device devicesOfDB = myDB.getDevices().get(currentId);

		assertEquals(devicesOfDB, devicesOfService);
	}
	
	@Test
	public void incorrectIdTest()
	{
		UUID randID = UUID.randomUUID();
		assertThrows(MissingDataException.class,
				()->myService.getDeviceByID(randID));
	}
}