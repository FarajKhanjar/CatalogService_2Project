package ajbc.webservice.rest.CatalogService.TCPclient;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ajbc.webservice.rest.CatalogService.models.Device;
import ajbc.webservice.rest.CatalogService.models.HardwareType;
import ajbc.webservice.rest.CatalogService.models.IOT_Thing;

public class TCPclient 
{
	private static List<Device> devicesList;
	private static List<IOT_Thing> iotThingsList;
	
//	public static List<IOTThing> newThingsList;
//	private static int index =0 ;
	
	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException 
	{
		
		final int SERVER_PORT = 8095;
		final String SERVER_NAME = "localhost";

		iotThingsList = createIOTThings();
	//	newThingsList = new ArrayList<IOTThing>();
		
		System.out.println("Original IOT-things DataBase:");
		System.out.println("-----------------------------");
		iotThingsList.forEach(System.out::println);
		printStatusDB("devices");
		
		ExecutorService clientsService = Executors.newFixedThreadPool(iotThingsList.size());

			iotThingsList.forEach(iotThing -> {
				try {
					
					iotThing.simulateInventoryChange();
					InventoryReport report = new InventoryReport(iotThing,new Socket(SERVER_NAME,SERVER_PORT));
					clientsService.execute(report);

				} catch (IOException e) {
				
					e.printStackTrace();
				}
//				finally 
//				{
//					newThingsList.add(thingsList.get(index));
//					index++;
//				}
			});
			
			printStatusDB("IOT things");
		
		clientsService.shutdown();
		clientsService.awaitTermination(30, TimeUnit.SECONDS);
	}
	
	private static void printStatusDB(String hardwareType)
	{
		System.out.println("\n-------------------");
		System.out.println("Current " + hardwareType+":");
		System.out.println("-------------------");
		if(hardwareType=="devices")
			devicesList.forEach(System.out::println);
		else
			iotThingsList.forEach(System.out::println);
		System.out.println();
	}
	
	public static List<IOT_Thing> createIOTThings() 
	{
		List<IOT_Thing> thingsList = Arrays.asList(
				new IOT_Thing(HardwareType.CONTROLLER,"V2X","communications",createListOfDevices1()),
				new IOT_Thing(HardwareType.CONTROLLER,"BLE","wireless",createListOfDevices2()),
				new IOT_Thing(HardwareType.CONTROLLER,"IoMT","Medical ",createListOfDevices3()));
		return thingsList;
	}
	
	public static List<Device> createListOfDevices1()
	{
		devicesList = new ArrayList<Device>();
		devicesList.add(new Device(HardwareType.SENSOR,"matrix","Biosensor"));
		devicesList.add(new Device(HardwareType.SENSOR,"CCD","ImageSensors"));
		devicesList.add(new Device(HardwareType.ACTUATOR,"2Acting","Electric"));
		devicesList.add(new Device(HardwareType.ACTUATOR,"HDR5","Hydraulic"));
		return devicesList;
	}
	
	public static List<Device> createListOfDevices2()
	{
		devicesList = new ArrayList<Device>();
		devicesList.add(new Device(HardwareType.SENSOR,"matrix","Biosensor"));
		devicesList.add(new Device(HardwareType.ACTUATOR,"HDR5","Hydraulic"));
		return devicesList;
	}
	
	public static List<Device> createListOfDevices3()
	{
		devicesList = new ArrayList<Device>();
		devicesList.add(new Device(HardwareType.SENSOR,"matrix","Biosensor"));
		devicesList.add(new Device(HardwareType.SENSOR,"FET","MOSsensors"));
		devicesList.add(new Device(HardwareType.SENSOR,"CCD","ImageSensors"));
		devicesList.add(new Device(HardwareType.ACTUATOR,"2Acting","Electric"));
		devicesList.add(new Device(HardwareType.ACTUATOR,"HDR5","Hydraulic"));
		return devicesList;
	}
	

}
