package catalogService.resourcesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import ajbc.webservice.rest.CatalogService.DBService.DBService;
import ajbc.webservice.rest.CatalogService.DataBase.DBMock;
import ajbc.webservice.rest.CatalogService.exceptions.MissingDataException;
import ajbc.webservice.rest.CatalogService.models.IOT_Thing;

public class IOT_ThingResourceTest 
{
	private DBService myService = new DBService();
	private DBMock myDB = DBMock.getInstance();
	
	@Test
	public void getAllIOTThingsTest()
	{
		List<IOT_Thing> serviceThings = myService.getAllIOTThings();
		List<IOT_Thing> dbThings = myDB.getIotThings().values().stream().toList();
		assertEquals(dbThings, serviceThings);
		
	}
	
	@Test
	public void getIOTThingByIdTest()
	{
		List<UUID> listOfId = myDB.getIotThings().keySet().stream().toList();
		UUID currentId = listOfId.get(0);
		IOT_Thing devicesOfService = myService.getIOTThingByID(currentId);
		IOT_Thing devicesOfDB = myDB.getIotThings().get(currentId);

		assertEquals(devicesOfDB, devicesOfService);
	}
	
	@Test
	public void incorrectIdTest()
	{
		UUID randID = UUID.randomUUID();
		assertThrows(MissingDataException.class,
				()->myService.getIOTThingByID(randID));		
	}
}