package ajbc.webservice.rest.CatalogService.DBService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import ajbc.webservice.rest.CatalogService.DataBase.DBMock;
import ajbc.webservice.rest.CatalogService.models.Device;
import ajbc.webservice.rest.CatalogService.models.IOT_Thing;

public class DBService 
{
	private volatile Map<UUID,IOT_Thing> iotThingsMap;
	private volatile Map<UUID,Device> devicesMap;
	private DBMock catalogDataBase;
	
	public DBService() 
	{
		catalogDataBase = DBMock.getInstance();
		iotThingsMap = catalogDataBase.getIotThings();
		devicesMap = catalogDataBase.getDevices();
	}

	public void addToDataBase(IOT_Thing iot_thing) 
	{
		if(!isEqual(iot_thing)) 
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

		if(iotThingsMap.containsKey(iot_thing.getID())) 
		{

		List<Device> originalDevices = iotThingsMap.get(iot_thing.getID()).getDevices();
		List<Device> newDevices = iot_thing.getDevices();
		
		originalDevices.forEach(device -> 
		{
			if(!newDevices.contains(device)) 
				devicesMap.remove(device.getID());});
		
		newDevices.forEach(device-> 
		{
			if(!originalDevices.contains(device)) 
				devicesMap.put(device.getID(), device);});
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
	
/////////
	

}
