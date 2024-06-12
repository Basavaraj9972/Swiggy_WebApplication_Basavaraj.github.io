package com.tap.model;

public class OrderHistory {
	private int orderHistoryId;
	private int userId_oh;
	private String orderId_oh;
	
//	orderHistoryId, userId_oh, orderId_oh
	public OrderHistory() {

	}

	public OrderHistory(int orderHistoryId, int userId_oh,String orderId_oh) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.userId_oh = userId_oh;
		this.orderId_oh = orderId_oh;
	}
	

	public OrderHistory(int userId_oh,String orderId_oh) {
		super();
		this.userId_oh = userId_oh;
		this.orderId_oh = orderId_oh;
	}
	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public String getOrderId_oh() {
		return orderId_oh;
	}

	public void setOrderId_oh(String orderId_oh) {
		this.orderId_oh = orderId_oh;
	}

	public int getUserId_oh() {
		return userId_oh;
	}

	public void setUserId_oh(int userId_oh) {
		this.userId_oh = userId_oh;
	}
	@Override
	public String toString() {
		return userId_oh+" "+orderId_oh+" "+userId_oh;
	}
	
}
