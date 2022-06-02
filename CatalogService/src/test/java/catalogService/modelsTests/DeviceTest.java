package catalogService.modelsTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ajbc.webservice.rest.CatalogService.models.Device;
import ajbc.webservice.rest.CatalogService.models.HardwareType;

class DeviceTest 
{

	Device templateDevice;
	
	public DeviceTest() 
	{
		templateDevice = new Device(HardwareType.CONTROLLER, "S1", "Solar-Edge");
	}
	
	@Test
	void checkDeviceHardwareType() 
	{
		assertEquals(HardwareType.CONTROLLER, templateDevice.getHardwareType());
		templateDevice.setHardwareType(HardwareType.SENSOR);
		assertEquals(HardwareType.SENSOR, templateDevice.getHardwareType());
		templateDevice.setHardwareType(HardwareType.ACTUATOR);
		assertEquals(HardwareType.ACTUATOR, templateDevice.getHardwareType());
	}
	
	@Test
	void checkModelDevice() 
	{
		assertEquals("S1", templateDevice.getModel());
		templateDevice.setModel("S10");
		assertEquals("S10", templateDevice.getModel());
	}
	
	@Test
	void checkManufacturerDevice() 
	{
		assertEquals("Solar-Edge", templateDevice.getManufacturer());
		templateDevice.setManufacturer("AJBC");
		assertEquals("AJBC", templateDevice.getManufacturer());
	}

}
