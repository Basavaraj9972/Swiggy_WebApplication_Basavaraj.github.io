package com.tap.model;

import java.time.LocalDateTime;

public class Order {
	private String orderId;
	private int restaurantId_och;
	private int userId_o;
	private float totalAmount;
	private String modeOfPayment;
	private String status;
	private String address;
	private LocalDateTime orderDateTime; 
	//orderId, restaurantId_och, userId_o, totalAmount, modeOfPayment, status, address, orderDateTime
	public Order() {

	}
	public Order(int restaurantId_och, int userId_o, float totalAmount, String modeOfPayment, String status,
			String address) {
		super();
		this.restaurantId_och = restaurantId_och;
		this.userId_o = userId_o;
		this.totalAmount = totalAmount;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
		this.address = address;
	}
	public Order(String orderId, int restaurantId_och, int userId_o, float totalAmount, String modeOfPayment,
			String status, String address, LocalDateTime orderDateTime) {
		super();
		this.orderId = orderId;
		this.restaurantId_och = restaurantId_och;
		this.userId_o = userId_o;
		this.totalAmount = totalAmount;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
		this.address = address;
		this.orderDateTime = orderDateTime;
	}
	public Order(String orderId, int restaurantId_och, int userId_o, float totalAmount, String modeOfPayment, String status,
			String address) {
		super();
		this.orderId = orderId;
		this.restaurantId_och = restaurantId_och;
		this.userId_o = userId_o;
		this.totalAmount = totalAmount;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
		this.address = address;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getUserId_o() {
		return userId_o;
	}
	public void setUserId_o(int userId_o) {
		this.userId_o = userId_o;
	}
	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	public int getRestaurantId_och() {
		return restaurantId_och;
	}
	public void setRestaurantId_och(int restaurantId_och) {
		this.restaurantId_och = restaurantId_och;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return orderId+" "+restaurantId_och+" "+userId_o+" "+totalAmount+" "+modeOfPayment+" "+status;
	}
}
