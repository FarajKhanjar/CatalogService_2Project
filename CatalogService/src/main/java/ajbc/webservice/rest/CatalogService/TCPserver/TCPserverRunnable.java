package ajbc.webservice.rest.CatalogService.TCPserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import ajbc.webservice.rest.CatalogService.DBService.DBService;
import ajbc.webservice.rest.CatalogService.models.IOT_Thing;

public class TCPserverRunnable implements Runnable 
{
	private DBService DBservice;
	
	private Socket clientSocket;

	
	public TCPserverRunnable(Socket clientSocket) 
	{
		this.clientSocket = clientSocket;
		DBservice = new DBService();
	}

	@Override
	public void run() 
	{
		try(BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);)
		{
			
			JsonReader readJSO = new JsonReader(bufferReader);
			
			Gson gson = new Gson();
			IOT_Thing iot_thing = gson.fromJson(readJSO, IOT_Thing.class);
			
			System.out.println("IOT_thing " + iot_thing.getID()+ " received from the [Client]");
			
			String message ;
			if(!DBservice.isEqual(iot_thing)) 
			{
				DBservice.addToDataBase(iot_thing);
				message = "IOT thing " + iot_thing.getID() + " added to DB";
			}
			else {
				DBservice.updateDataBase(iot_thing);
				message = "Updatint devices is done for IOT_thing: " + iot_thing.getID();
			}
			
			writer.println(message);
			
		} catch (IOException e) 
		{
////
			e.printStackTrace();
		}

	}

}
