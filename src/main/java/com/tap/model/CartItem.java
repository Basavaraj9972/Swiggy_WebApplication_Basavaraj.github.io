package com.tap.model;

public class CartItem {
	private int itemId;
	private int restId;
	private String name;
	private float price;
	private int quantity;
	private String imgPath;
	
	
	public CartItem() {

	}

	public CartItem(int itemId, int restId, String name, float price, int quantity, String imgPath) {
		super();
		this.itemId = itemId;
		this.restId = restId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.imgPath = imgPath;
	}

	public CartItem(int itemId, int restId, String name, float price, int quantity) {
		super();
		this.itemId = itemId;
		this.restId = restId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
}
