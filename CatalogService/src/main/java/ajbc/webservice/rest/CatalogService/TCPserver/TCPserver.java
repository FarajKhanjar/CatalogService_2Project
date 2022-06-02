package ajbc.webservice.rest.CatalogService.TCPserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ajbc.webservice.rest.CatalogService.DBService.DBService;
import ajbc.webservice.rest.CatalogService.DataBase.DBMock;

public class TCPserver 
{
	private final int SERVER_PORT;

	public TCPserver(int SERVER_PORT) 
	{
		this.SERVER_PORT = SERVER_PORT;
	}

	public void runTCPserver() throws InterruptedException 
	{
		ExecutorService executorService = Executors.newCachedThreadPool();

		try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT);) 
		{

			System.out.println("[Server] started on port: " + SERVER_PORT);

			while (true) 
			{
				Socket clientSocket = serverSocket.accept();
				executorService.execute(new TCPserverRunnable(clientSocket));
			}
		} catch (IOException e) {
			System.err.println("[Server] failed to start on port: " + SERVER_PORT);
			e.printStackTrace();
		} 
		finally 
		{
			executorService.shutdown();
			executorService.awaitTermination(3, TimeUnit.SECONDS);
		}

	}

	public static void main(String[] args) throws InterruptedException 
	{
		
		int serverPort = 8095;
		TCPserver inventoryServer = new TCPserver(serverPort);
		inventoryServer.runTCPserver();

	}

}
