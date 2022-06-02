package catalogService.modelsTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ajbc.webservice.rest.CatalogService.models.Device;
import ajbc.webservice.rest.CatalogService.models.HardwareType;
import ajbc.webservice.rest.CatalogService.models.IOT_Thing;

class IOT_ThingTest 
{

	IOT_Thing templateIotThing;

	List<Device> devicesList = new ArrayList<Device>();

	Device device_1 = new Device(HardwareType.SENSOR, "matrix", "Biosensor");
	Device device_2 = new Device(HardwareType.ACTUATOR, "FET", "MOSsensors");
	Device device_3 = new Device(HardwareType.SENSOR, "CCD", "ImageSensors");
	Device device_4 = new Device(HardwareType.ACTUATOR, "2Acting", "Electric");
	Map<UUID, Device> devices;
	
	IOT_ThingTest()
	{
		devicesList.add(device_1);
		devicesList.add(device_2);
		devicesList.add(device_3);
		
		templateIotThing = new IOT_Thing(HardwareType.CONTROLLER,"V2X","communications",devicesList);
		
		devices = new HashMap<UUID, Device>();
		devices.put(device_1.getID(), device_1);
		devices.put(device_2.getID(), device_2);
	}
	
	@Test
	@DisplayName("constractorTest")
	void constractorTest() 
	{
		assertEquals(templateIotThing.getHardwareType(), HardwareType.CONTROLLER );
		assertEquals(templateIotThing.getManufacturer(), "communications");
		assertEquals(templateIotThing.getModel(), "V2X");
		assertEquals(templateIotThing.getDevices(), devicesList);
		
		assertFalse(templateIotThing.getDevices().isEmpty());
	}
	
	@Test
	void deviceManufacturerTest() 
	{
		assertEquals("communications", templateIotThing.getManufacturer());
		templateIotThing.setManufacturer("Acology");
		assertEquals("Acology", templateIotThing.getManufacturer());
	}
	
	@Test
	void hardwareTypeTest() 
	{
		assertEquals(HardwareType.CONTROLLER, templateIotThing.getHardwareType());
		templateIotThing.setHardwareType(HardwareType.ACTUATOR);
		assertEquals(HardwareType.ACTUATOR, templateIotThing.getHardwareType());
		templateIotThing.setHardwareType(HardwareType.SENSOR);
		assertEquals(HardwareType.SENSOR, templateIotThing.getHardwareType());
	}
	
	@Test
	void deviceModelTest() 
	{
		assertEquals("V2X", templateIotThing.getModel());
		templateIotThing.setModel("TT5");
		assertEquals("TT5", templateIotThing.getModel());
	}
	
	
}
