package com.tap.dao;
import java.util.List;

import com.tap.model.Order;
public interface OrderDao {
	public void addOrder(Order order);
	public Order getOrder(String orderId);
	public void updateOrder(Order order);
	public void deleteOrder(String orderId);
	public List<Order> getAllOrder();
	
}
