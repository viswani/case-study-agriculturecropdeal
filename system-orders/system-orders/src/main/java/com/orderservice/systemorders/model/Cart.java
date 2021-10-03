package com.orderservice.systemorders.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cartList")
public class Cart {
	
	
	@Id
	private String id;
	private String cropType;
	private String cropName;
	private String quant;
	private double price;
	private double totalPrice;
	private double quantityRequired;
	private String dealerId;
	public Cart() {
		super();
	}
	
	public Cart(String id, String cropType, String cropName, String quant, double price, double totalPrice,
			double quantityRequired, String dealerId) {
		super();
		this.id = id;
		this.cropType = cropType;
		this.cropName = cropName;
		this.quant = quant;
		this.price = price;
		this.totalPrice = totalPrice;
		this.quantityRequired = quantityRequired;
		this.dealerId = dealerId;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getQuant() {
		return quant;
	}
	public void setQuant(String quant) {
		this.quant = quant;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getQuantityRequired() {
		return quantityRequired;
	}
	public void setQuantityRequired(double quantityRequired) {
		this.quantityRequired = quantityRequired;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}
	

}
