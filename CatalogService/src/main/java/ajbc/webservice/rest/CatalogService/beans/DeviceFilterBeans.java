package ajbc.webservice.rest.CatalogService.beans;

import jakarta.ws.rs.QueryParam;
import java.util.UUID;

public class DeviceFilterBeans 
{
	@QueryParam("hardwareType") String hardwareType;
	@QueryParam("model") String model;
	@QueryParam("manufacturer") String manufacturer;
	
	public String getHardwareType() {
		return hardwareType;
	}
	public void sethardwareType(String hardwareType) {
		this.hardwareType = hardwareType;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
