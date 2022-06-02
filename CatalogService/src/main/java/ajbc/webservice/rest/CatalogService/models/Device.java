package ajbc.webservice.rest.CatalogService.models;

public class Device extends Hardware
{
	//private String iot_thingModel;
	public Device(HardwareType hardwareType, String model, String manufacturer) 
	{
		super(hardwareType, model, manufacturer);
	}
	
//	public Device(HardwareType hardwareType, String model, String manufacturer, String iot_thingModel) 
//	{
//		super(hardwareType, model, manufacturer);
//		this.iot_thingModel =iot_thingModel;
//	}
	
	public Device() 
	{
		super();
	}

	
	@Override
	public String toString() {
		return "Device [ " + super.toString()+ " ]";//, "+iot_thingModel+" ]";
	}

}