package ajbc.webservice.rest.CatalogService.DataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import ajbc.webservice.rest.CatalogService.TCPclient.TCPclient;
import ajbc.webservice.rest.CatalogService.models.Device;
import ajbc.webservice.rest.CatalogService.models.HardwareType;
import ajbc.webservice.rest.CatalogService.models.IOT_Thing;

public class DBMock {
	
	private static DBMock instance = null;
	private static Map<UUID,IOT_Thing> iotThings;
	private static Map<UUID,Device> devices;
	
	//public static Map<UUID,IOTThing> new_iotThings;
	
	public static synchronized DBMock getInstance() 
	{
		//singalton 
		if(instance==null)
			instance = new DBMock();
		return instance;
	}
	
	private DBMock() {
		iotThings = new HashMap<UUID,IOT_Thing>();
		devices = new HashMap<UUID,Device>();
		manageDataBase();
		//seedthings();
	}

	public Map<UUID, IOT_Thing> getIotThings() 
	{
	
		return iotThings;
	}

	public Map<UUID, Device> getDevices() 
	{
		return devices;
	}

//	public static  Map<UUID, IOTThing> seedthings() 
//	{	
//		List<IOTThing> thingsList = ClientRunner.newThingsList;
//		
//		new_iotThings = thingsList.stream()
//	      .collect(Collectors.toMap(IOTThing::getUuid, Function.identity()));
//		
//		return new_iotThings;
//	}
	
	private void manageDataBase() 
	{
		List<IOT_Thing> thingsList = createIOTThings();
		thingsList.forEach(thing -> iotThings.put(thing.getID(), thing));
		thingsList.forEach(System.out::println);
	}
	
	public static List<IOT_Thing> createIOTThings() 
	{
		List<IOT_Thing> thingsList = Arrays.asList(
				new IOT_Thing(HardwareType.CONTROLLER,"V2X","communications",createListOfDevices1()),
				new IOT_Thing(HardwareType.CONTROLLER,"BLE","wireless",createListOfDevices2()),
				new IOT_Thing(HardwareType.CONTROLLER,"IoMT","Medical ",createListOfDevices3()));
		return thingsList;
	}
	
//	public static List<Device> createListOfDevices()
//	{
//		List<Device> devicesList = new ArrayList<Device>();
//		devicesList.add(new Device(HardwareType.SENSOR,"matrix","Biosensor"));
//		devicesList.add(new Device(HardwareType.SENSOR,"FET","MOSsensors"));
//		devicesList.add(new Device(HardwareType.SENSOR,"CCD","ImageSensors"));
//		devicesList.add(new Device(HardwareType.ACTUATOR,"2Acting","Electric"));
//		devicesList.add(new Device(HardwareType.ACTUATOR,"HDR5","Hydraulic"));
//		return devicesList;
//	}
	
	public static List<Device> createListOfDevices1()
	{
		List<Device> devicesList = new ArrayList<Device>();
		devicesList.add(new Device(HardwareType.SENSOR,"matrix","Biosensor"));
		devicesList.add(new Device(HardwareType.SENSOR,"CCD","ImageSensors"));
		devicesList.add(new Device(HardwareType.ACTUATOR,"2Acting","Electric"));
		devicesList.add(new Device(HardwareType.ACTUATOR,"HDR5","Hydraulic"));
		return devicesList;
	}
	
	public static List<Device> createListOfDevices2()
	{
		List<Device> devicesList = new ArrayList<Device>();
		devicesList.add(new Device(HardwareType.SENSOR,"matrix","Biosensor"));
		devicesList.add(new Device(HardwareType.ACTUATOR,"HDR5","Hydraulic"));
		return devicesList;
	}
	
	public static List<Device> createListOfDevices3()
	{
		List<Device> devicesList = new ArrayList<Device>();
		devicesList.add(new Device(HardwareType.SENSOR,"matrix","Biosensor"));
		devicesList.add(new Device(HardwareType.SENSOR,"FET","MOSsensors"));
		devicesList.add(new Device(HardwareType.SENSOR,"CCD","ImageSensors"));
		devicesList.add(new Device(HardwareType.ACTUATOR,"2Acting","Electric"));
		devicesList.add(new Device(HardwareType.ACTUATOR,"HDR5","Hydraulic"));
		return devicesList;
	}
	
	
	
	
}