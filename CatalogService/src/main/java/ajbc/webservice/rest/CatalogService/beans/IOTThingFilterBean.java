package ajbc.webservice.rest.CatalogService.beans;

import jakarta.ws.rs.QueryParam;

/**
 * Through this class the HTTP server do the filtering or resourcing.
 * @author Faraj
 */
public class IOTThingFilterBean 
{
	@QueryParam("hardwareType") String type;
	@QueryParam("model") String model;
	@QueryParam("manufacturer") String manufacturer;
	
	public String getHardwareType() {
		return type;
	}
	public void setHardwareType(String type) {
		this.type = type;
	}
	public String getModle() {
		return model;
	}
	public void setModle(String modle) {
		this.model = modle;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
}