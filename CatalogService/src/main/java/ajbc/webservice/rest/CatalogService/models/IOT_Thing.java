package ajbc.webservice.rest.CatalogService.models;

import java.util.List;

public class IOT_Thing extends Hardware
{
	private List<Device> devices;

	public IOT_Thing() 
	{
		super();
	}
	
	public IOT_Thing(HardwareType hardwareType, String model, String manufacturer, List<Device> devices) 
	{
		super(hardwareType, model, manufacturer);
		this.devices = devices;
	}
	
	public List<Device> getDevices() 
	{
		return devices;
	}
	
	public void simulateInventoryChange() 
	{
		if(devices.isEmpty()==false) 
		{
			removingValuefromMap();
		}
		addValueToMap();
	}
	
	public void removingValuefromMap() 
	{
		int size = devices.size();
		int index = (int)(Math.random()*size);
		System.out.println("[Client] ask to remove device #" + index);
		devices.remove(index);
	}
	
	public void addValueToMap() 
	{
		int size = devices.size();
		int index = (int)(Math.random()*size);
		System.out.println("[Client] ask to add a new device to DB in #"+index);
		devices.add(index, new Device(HardwareType.ACTUATOR,"SMAs","Thermal"));
	}

	@Override
	public String toString() 
	{
		return super.toString()+"IOT_Thing [devices=" + devices + "]";
	}

}
