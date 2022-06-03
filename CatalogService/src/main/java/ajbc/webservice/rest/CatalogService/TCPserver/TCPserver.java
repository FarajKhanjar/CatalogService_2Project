package ajbc.webservice.rest.CatalogService.TCPserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The TCP server is waiting for the client, listen to the client port,
 * and manages it by executing ServerSocketThread, also send and write messages for the client.
 * @author Faraj
 */
public class TCPserver extends Thread
{
	ExecutorService executorService;
	private final int SERVER_PORT;

	public TCPserver(int SERVER_PORT) 
	{
		this.SERVER_PORT = SERVER_PORT;
		executorService = Executors.newCachedThreadPool();
	}

	@Override
	public void run() 
	{
		try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT);) 
		{
			System.out.println("[Server] started on port: " + SERVER_PORT);

			while (true) 
			{
				Socket clientSocket = serverSocket.accept();
				executorService.execute(new TCPserverRunnable(clientSocket));
			}
		} 
		catch (IOException e) 
		{
			System.err.println("[Server] failed to run on port: " + SERVER_PORT);
			e.printStackTrace();
		} 
	}
	
	public void kill() 
	{
		try 
		{
			executorService.shutdown();
			executorService.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException 
	{
		
		int serverPort = 8095;
		TCPserver inventoryServer = new TCPserver(serverPort);
		inventoryServer.run();

	}

}
