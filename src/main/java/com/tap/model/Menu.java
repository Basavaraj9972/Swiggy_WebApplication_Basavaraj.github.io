package com.tap.model;

public class Menu implements Comparable<Menu>{
	private int menuId;
	private String name;
	private float price;
	private String description;
	private String imagepath;
	private boolean isAvailable;
	private int restaurantId;
	private float rating;
	
	public Menu() {

	}

	public Menu(int menuId, String name, float price, String description, String imagepath, boolean isAvailable,
			float rating,int restaurantId) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imagepath = imagepath;
		this.isAvailable = isAvailable;
		this.restaurantId = restaurantId;
		this.rating = rating;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return menuId+" "+name+" "+price+" "+description+" "+imagepath+" "+isAvailable+restaurantId+" "+rating ;
	}

	@Override
	public int compareTo(Menu menu) {
		Menu menu1 = this ;
		return menu1.menuId-menu.menuId;
	}
	
	
	

}
