package ajbc.webservice.rest.CatalogService.models;

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