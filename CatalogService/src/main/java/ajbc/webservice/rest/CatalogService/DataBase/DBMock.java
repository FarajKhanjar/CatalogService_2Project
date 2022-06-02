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
import ajbc.webservice.rest.CatalogService.TCPserver.TCPserver;
import ajbc.webservice.rest.CatalogService.models.Device;
import ajbc.webservice.rest.CatalogService.models.HardwareType;
import ajbc.webservice.rest.CatalogService.models.IOT_Thing;

public class DBMock 
{
	private static DBMock instance = null;
	private static Map<UUID, IOT_Thing> iotThingsMap;
	public static Map<UUID, Device> devicesMap;

	// public static Map<UUID,IOTThing> new_iotThings;

	public static synchronized DBMock getInstance() 
	{
		// singalton
		if (instance == null)
			instance = new DBMock();
		return instance;
	}

	private DBMock() 
	{
		iotThingsMap = new HashMap<UUID, IOT_Thing>();
		devicesMap = new HashMap<UUID, Device>();

		manageDataBase();
	}

	private void manageDataBase() 
	{
		List<IOT_Thing> thingsList = initIOTthingsData();
		thingsList.forEach(thing -> iotThingsMap.put(thing.getID(), thing));
		thingsList.forEach(System.out::println);

	}

	public static List<IOT_Thing> initIOTthingsData() 
	{
		List<IOT_Thing> thingsList = Arrays.asList(
				new IOT_Thing(HardwareType.CONTROLLER, "V2X", "communications", initListOfDBDevices1()),
				new IOT_Thing(HardwareType.CONTROLLER, "BLE", "wireless", initListOfDBDevices2()),
				new IOT_Thing(HardwareType.CONTROLLER, "IoMT", "Medical ", initListOfDBDevices3()));
		return thingsList;
	}

	public static List<Device> initListOfDBDevices1() 
	{
		List<Device> devicesList = new ArrayList<Device>();
		devicesList.add(new Device(HardwareType.SENSOR, "matrix", "Biosensor"));
		devicesList.add(new Device(HardwareType.SENSOR, "CCD", "ImageSensors"));
		devicesList.add(new Device(HardwareType.ACTUATOR, "2Acting", "Electric"));
		devicesList.add(new Device(HardwareType.ACTUATOR, "HDR5", "Hydraulic"));

		devicesList.forEach(device -> devicesMap.put(device.getID(), device));
		devicesList.forEach(System.out::println);

		return devicesList;
	}

	public static List<Device> initListOfDBDevices2() 
	{
		List<Device> devicesList = new ArrayList<Device>();
		devicesList.add(new Device(HardwareType.SENSOR, "matrix", "Biosensor"));
		devicesList.add(new Device(HardwareType.ACTUATOR, "HDR5", "Hydraulic"));

		devicesList.forEach(device -> devicesMap.put(device.getID(), device));
		devicesList.forEach(System.out::println);

		return devicesList;
	}

	public static List<Device> initListOfDBDevices3() 
	{
		List<Device> devicesList = new ArrayList<Device>();
		devicesList.add(new Device(HardwareType.SENSOR, "matrix", "Biosensor"));
		devicesList.add(new Device(HardwareType.SENSOR, "FET", "MOSsensors"));
		devicesList.add(new Device(HardwareType.SENSOR, "CCD", "ImageSensors"));
		devicesList.add(new Device(HardwareType.ACTUATOR, "2Acting", "Electric"));
		devicesList.add(new Device(HardwareType.ACTUATOR, "HDR5", "Hydraulic"));

		devicesList.forEach(device -> devicesMap.put(device.getID(), device));
		devicesList.forEach(System.out::println);

		return devicesList;
	}

//	public static List<IOT_Thing> createListOfAllIOTThings() 
//	{
//		List<IOT_Thing> thingsList = Arrays.asList(
//				new IOT_Thing(HardwareType.CONTROLLER,"V2X","communications",createListOfAllDevices()),
//				new IOT_Thing(HardwareType.CONTROLLER,"BLE","wireless",createListOfAllDevices()),
//				new IOT_Thing(HardwareType.CONTROLLER,"IoMT","Medical ",createListOfAllDevices()));
//		return thingsList;
//	}

	public static List<Device> createListOfAllDevices() 
	{
		List<Device> devicesList = new ArrayList<Device>();
		devicesList.add(new Device(HardwareType.SENSOR, "matrix", "Biosensor"));
		devicesList.add(new Device(HardwareType.SENSOR, "FET", "MOSsensors"));
		devicesList.add(new Device(HardwareType.SENSOR, "CCD", "ImageSensors"));
		devicesList.add(new Device(HardwareType.ACTUATOR, "2Acting", "Electric"));
		devicesList.add(new Device(HardwareType.ACTUATOR, "HDR5", "Hydraulic"));

		devicesList.forEach(device -> devicesMap.put(device.getID(), device));
		devicesList.forEach(System.out::println);
		return devicesList;
	}

	public Map<UUID, IOT_Thing> getIotThings() 
	{

		return iotThingsMap;
	}

	public Map<UUID, Device> getDevices() 
	{
		return devicesMap;
	}
}