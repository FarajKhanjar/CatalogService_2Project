package ajbc.webservice.rest.CatalogService.DBService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import ajbc.webservice.rest.CatalogService.DataBase.DBMock;
import ajbc.webservice.rest.CatalogService.models.Device;
import ajbc.webservice.rest.CatalogService.models.HardwareType;
import ajbc.webservice.rest.CatalogService.models.IOT_Thing;

public class DBService 
{
	private volatile Map<UUID, IOT_Thing> iotThingsMap;
	private volatile Map<UUID, Device> devicesMap;
	private DBMock catalogDataBase;

	public DBService() 
	{
		catalogDataBase = DBMock.getInstance();
		iotThingsMap = catalogDataBase.getIotThings();
		devicesMap = catalogDataBase.getDevices();
	}

	public void addToDataBase(IOT_Thing iot_thing) 
	{
		if (!isEqual(iot_thing)) 
		{
			iotThingsMap.put(iot_thing.getID(), iot_thing);
			iot_thing.getDevices().forEach(device -> devicesMap.put(device.getID(), device));
		}
	}

	public boolean isEqual(IOT_Thing iot_thing) 
	{
		return iotThingsMap.containsKey(iot_thing.getID());
	}

	public void updateDataBase(IOT_Thing iot_thing) 
	{

		if (iotThingsMap.containsKey(iot_thing.getID())) 
		{

			List<Device> originalDevices = iotThingsMap.get(iot_thing.getID()).getDevices();
			List<Device> newDevices = iot_thing.getDevices();

			originalDevices.forEach(device -> {
				if (!newDevices.contains(device))
					devicesMap.remove(device.getID());
			});

			newDevices.forEach(device -> {
				if (!originalDevices.contains(device))
					devicesMap.put(device.getID(), device);
			});
		}
	}

	public List<IOT_Thing> getAllIOTThings() 
	{
		return new ArrayList<IOT_Thing>(iotThingsMap.values());
	}

	public List<Device> getAllDevices() 
	{
		return new ArrayList<Device>(devicesMap.values());
	}

	public IOT_Thing getIOTThingByID(UUID ID) 
	{
		return iotThingsMap.get(ID);
	}

	public Device getDeviceByID(UUID ID) 
	{
		return devicesMap.get(ID);
	}

	public IOT_Thing getIOTThingByProperties(String hardwareType, String model, String manufacturer) 
	{

		HardwareType type = HardwareType.valueOf(hardwareType.toUpperCase());
		List<IOT_Thing> thingsList = iotThingsMap.values().stream().collect(Collectors.toList());
		for (IOT_Thing iotThing : thingsList) 
		{
			if (iotThing.getModel().equalsIgnoreCase(model) && iotThing.getHardwareType() == type
					&& iotThing.getManufacturer().equalsIgnoreCase(manufacturer)) 
			{
				return iotThing;
			}
		}

		return null;
	}

	public Device getDevicesByProperties(String hardwareType, String model, String manufacturer) 
	{
		HardwareType type = HardwareType.valueOf(hardwareType.toUpperCase());

		List<Device> devicesList = devicesMap.values().stream().collect(Collectors.toList());
		for (Device device : devicesList) 
		{
			if (device.getModel().equalsIgnoreCase(model) && device.getHardwareType() == type
					&& device.getManufacturer().equalsIgnoreCase(manufacturer)) 
			{
				return device;
			}
		}

		return null;
	}

	public List<Device> getDevicesByIOTthingId(UUID ID) 
	{
		List<Device> devices = null;
		IOT_Thing iotThings = iotThingsMap.get(ID);
		devices = iotThings.getDevices();

		return devices;
	}

//	public List<IOT_Thing> getIOTthingByDevicesId(UUID ID) 
//	{
//		List<IOT_Thing> iots = null;
//		Device devices = devicesMap.get(ID);
//		
//		List<IOT_Thing> thingsList = iotThingsMap.values().stream().collect(Collectors.toList());
//		for(IOT_Thing iotThing : thingsList) 
//		{
//			if(iotThing.getDevices().g.equals(devices)) 
//			{
//				iots.add(iotThing);
//			}	
//		}
//		return iots;
//	}

}
