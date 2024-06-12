package com.tap.model;

public class OrderItems {
	private int orderItemId;
	private int userId;
	private int menuId;
	private String itemName;
	private int quantity;
	private float price;
	private String orderId_item;
//	orderItemId, userId, menuId, itemName, quantity, price, orderId_item
	public OrderItems() {

	}
	
	public OrderItems(int orderItemId, int userId, int menuId, String itemName, int quantity, float price,
		String orderId_item) {
	super();
	this.orderItemId = orderItemId;
	this.userId = userId;
	this.menuId = menuId;
	this.itemName = itemName;
	this.quantity = quantity;
	this.price = price;
	this.orderId_item = orderId_item;
}

	public OrderItems(int userId, int menuId, String itemName, int quantity, float price,
			String orderId_item) {
	super();
	this.userId = userId;
	this.menuId = menuId;
	this.itemName = itemName;
	this.quantity = quantity;
	this.price = price;
	this.orderId_item = orderId_item;
}
	public OrderItems(int userId, int menuId, String itemName, int quantity, float price) {
		super();
		this.userId = userId;
		this.menuId = menuId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public OrderItems(int orderItemId, int userId, int menuId, String itemName, int quantity, float price) {
		super();
		this.orderItemId = orderItemId;
		this.userId = userId;
		this.menuId = menuId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}


	public String getOrderId_item() {
		return orderId_item;
	}


	public void setOrderId_item(String orderId_item) {
		this.orderId_item = orderId_item;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	@Override
	public String toString() {
		return orderItemId+" "+userId+" "+menuId+" "+itemName+" "+quantity+" "+price;
	}
}
