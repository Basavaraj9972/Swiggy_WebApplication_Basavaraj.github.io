package com.tap.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Restaurant {
	private int restaurantId;
	private String name;
	private String imagePath;
	private float rating;
	private int eta;
	private String cuisinType;
	private String address;
	private boolean isActive;
	private int restaurantOwnId;
	
	public Restaurant() {
		
	}

	public Restaurant(int restaurantId, String name, String imagePath, float rating, int eta, String cuisinType,
			String address, boolean isActive, int restaurantOwnId) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.imagePath = imagePath;
		this.rating = rating;
		this.eta = eta;
		this.cuisinType = cuisinType;
		this.address = address;
		this.isActive = isActive;
		this.restaurantOwnId = restaurantOwnId;
	}
	
	
	public Restaurant(String name, String imagePath, float rating, int eta, String cuisinType, String address,
			boolean isActive, int restaurantOwnId) {
		super();
		this.name = name;
		this.imagePath = imagePath;
		this.rating = rating;
		this.eta = eta;
		this.cuisinType = cuisinType;
		this.address = address;
		this.isActive = isActive;
		this.restaurantOwnId = restaurantOwnId;
	}

	public Restaurant(int restaurantId) {
		super();
		this.restaurantId = restaurantId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getCuisinType() {
		return cuisinType;
	}

	public void setCuisinType(String cuisinType) {
		this.cuisinType = cuisinType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getRestaurantOwnId() {
		return restaurantOwnId;
	}

	public void setRestaurantOwnId(int restaurantOwnId) {
		this.restaurantOwnId = restaurantOwnId;
	}
	
	@Override
	public String toString() {
		return restaurantId+" "+name+" "+imagePath+" "+rating+" "+eta+" "+cuisinType+" "+address+" "+isActive+" "+restaurantOwnId;
	}
		
}
