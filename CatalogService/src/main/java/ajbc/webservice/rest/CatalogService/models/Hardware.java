package ajbc.webservice.rest.CatalogService.models;

import java.util.UUID;

public abstract class Hardware 
{
	private final UUID ID;
	private HardwareType hardwareType;
	private String model;
	private String manufacturer;

	public Hardware(HardwareType hardwareType, String model, String manufacturer) 
	{
		ID = UUID.randomUUID();
		this.hardwareType = hardwareType;
		this.model = model;
		this.manufacturer = manufacturer;
	}
	
	public Hardware() 
	{
		ID = UUID.randomUUID();
	}
	
	public UUID getID() 
	{
		return ID;
	}


	public HardwareType getHardwareType() 
	{
		return hardwareType;
	}

	public String getManufacturer() 
	{
		return manufacturer;
	}
	
	public String getModel() 
	{
		return model;
	}
	
	public void setHardwareType(HardwareType hardwareType) 
	{
		this.hardwareType = hardwareType;
	}

	public void setModel(String model) 
	{
		this.model = model;
	}

	public void setManufacturer(String manufacturer) 
	{
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() 
	{
		return "Hardware [ID=" + ID + ", hardwareType=" + hardwareType + ", model=" + model + ", manufacturer=" + manufacturer + "]";
	}
}