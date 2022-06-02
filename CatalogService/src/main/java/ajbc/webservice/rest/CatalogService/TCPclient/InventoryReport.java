package ajbc.webservice.rest.CatalogService.TCPclient;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import com.google.gson.Gson;

import ajbc.webservice.rest.CatalogService.models.IOT_Thing;

public class InventoryReport implements Runnable 
{
	private IOT_Thing iot_thing;
	private Socket clientSocket;

	public InventoryReport(IOT_Thing thing, Socket clientSocket) 
	{
		this.iot_thing = thing;
		this.clientSocket = clientSocket;
	}
	
	@Override
	public void run() 
	{
		try(BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);)
		{
			
			System.out.println("[Client] connected to [server]");
			
			Gson gson = new Gson();
			String thingJson = gson.toJson(iot_thing, iot_thing.getClass());
			
			
			writer.println(thingJson);
			System.out.println("[Client] #{"+ iot_thing.getID() +"} sent to the [server]");
			
			System.out.println(bufferReader.readLine());

			
		} catch (IOException e) 
		{
/////
			e.printStackTrace();
		}

	}

}
