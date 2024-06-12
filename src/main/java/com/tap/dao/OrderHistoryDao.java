package com.tap.dao;

import java.util.List;

import com.tap.model.OrderHistory;

public interface OrderHistoryDao {
	public void addOrderHistory(OrderHistory orderHistory);
	public OrderHistory getOrderHistory(int orderHistoryId);
	public void  updateOrderHistory(OrderHistory orderHistory);
	public void deleteOrderHistory(int orderHistoryId);
	public List<OrderHistory> getallOrderHistory();
}
