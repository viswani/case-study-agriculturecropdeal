package com.agcropdeal.servicecrop.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="crop")
public class Crop {
	@Id
	String id;
	String cropName;
	double price;
	String quant;
	String category;
	String address;
	String farmerId;
	public Crop() {
		
	}
	public Crop(String id, String cropName, double price, String quant, String category,String address,String farmerId) {
		super();
		this.id = id;
		this.cropName = cropName;
		this.price = price;
		this.quant = quant;
		this.category = category;
		this.address=address;
		this.farmerId=farmerId;
		}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getQuant() {
		return quant;
	}
	public void setQuant(String quant) {
		this.quant = quant;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}
	
	
	

}
