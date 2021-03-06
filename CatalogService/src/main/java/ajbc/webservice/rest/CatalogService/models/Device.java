package ajbc.webservice.rest.CatalogService.models;

/**
 * In this class we create the Device object,
 * its extends Hardware Class.
 * Devices can be sensors or actuators.
 * @author Faraj
 */
public class Device extends Hardware
{

	public Device(HardwareType hardwareType, String model, String manufacturer) 
	{
		super(hardwareType, model, manufacturer);
	}
	
	public Device() 
	{
		super();
	}

	
	@Override
	public String toString() {
		return "Device [ " + super.toString()+ " ]";
	}

}