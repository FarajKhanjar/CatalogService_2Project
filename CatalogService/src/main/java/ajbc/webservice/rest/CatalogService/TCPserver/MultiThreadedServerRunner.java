package ajbc.webservice.rest.CatalogService.TCPserver;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * The TCP server and the "Tomcat" server needs to sync/merges the actions by MultiThraededServerRunner.
 * @author Faraj
 */
@WebListener
public class MultiThreadedServerRunner implements ServletContextListener {

	private final int PORT = 8095;
	TCPserver server;

	public void contextInitialized(ServletContextEvent event) {

		server = new TCPserver(PORT);
		server.start();

	}

	public void contextDestroyed(ServletContextEvent event) {
		server.kill();
	}
}