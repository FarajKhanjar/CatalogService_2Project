package catalogService.modelsTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ajbc.webservice.rest.CatalogService.models.HardwareType;

class HardwareTest 
{
	String type_1 = "CONTROLLER";
	String type_2 = "ACTUATOR";
	String type_3 = "SENSOR";

	@Test
	void checkTypsOfHardware() 
	{
		assertTrue(type_1.equals(HardwareType.CONTROLLER.toString()));
		assertTrue(type_2.equals(HardwareType.ACTUATOR.toString()));
		assertTrue(type_3.equals(HardwareType.SENSOR.toString()));

	}

}
