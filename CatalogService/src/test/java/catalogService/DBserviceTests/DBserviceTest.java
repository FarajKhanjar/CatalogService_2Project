package catalogService.DBserviceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import ajbc.webservice.rest.CatalogService.DBService.DBService;
import ajbc.webservice.rest.CatalogService.DataBase.DBMock;
import ajbc.webservice.rest.CatalogService.models.Device;
import ajbc.webservice.rest.CatalogService.models.HardwareType;
import ajbc.webservice.rest.CatalogService.models.IOT_Thing;

class DBserviceTest 
{
	
	private DBService dbService= new DBService();

	
	@Test
	void constructorTest() 
	{
		assertEquals(DBMock.getInstance().getIotThings()
				     .values().stream().collect(Collectors.toList())
				     ,dbService.getAllIOTThings());
		
		assertEquals(DBMock.getInstance().getDevices()
				     .values().stream().collect(Collectors.toList()),
				     dbService.getAllDevices());
	}
	
	@Test
	void updateDataBaseTest() 
	{
		List<Device> devicesList = new ArrayList<Device>();
		devicesList.add(new Device(HardwareType.SENSOR, "matrix", "Biosensor"));
		devicesList.add(new Device(HardwareType.ACTUATOR, "HDR5", "Hydraulic"));
		
		IOT_Thing iotThing = new IOT_Thing(HardwareType.CONTROLLER, "BLE", "wireless", devicesList);
		
		iotThing.removingValuefromMap();
		iotThing.addValueToMap();
		dbService.updateDataBase(iotThing);	
	}

}
