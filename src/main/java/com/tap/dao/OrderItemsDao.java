package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItems;

public interface OrderItemsDao {
	public void addOrderItems(OrderItems orderItems);
	public OrderItems getOrderItems(int orderItemId);
	public void updateOrderItems(OrderItems orderItems);
	public void deleteOrderItems(int orderItemId);
	public List<OrderItems> getAllOrderItems();
	public List<OrderItems> getAllOrderItemsThroughUserId(int userId);
	public List<OrderItems> getAllOrderItemsThroughOrderId(String orderId);
	
}
