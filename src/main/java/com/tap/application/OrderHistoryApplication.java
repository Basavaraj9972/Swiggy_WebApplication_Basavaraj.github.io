package com.tap.application;

import java.util.List;

import com.tap.daoImp.OrderHistoryDaoImpl;
import com.tap.model.OrderHistory;

public class OrderHistoryApplication {

	public static void main(String[] args) {
		OrderHistoryDaoImpl orderHistoryDaoImpl = new OrderHistoryDaoImpl();
//		OrderHistory orderHistory = new OrderHistory(2,1,4);
//		orderHistoryDaoImpl.addOrderHistory(orderHistory);
//		OrderHistory orderHistory = orderHistoryDaoImpl.getOrderHistory(2);
//		System.out.println(orderHistory);
//		orderHistory.setOrderId_oh(3);
//		orderHistoryDaoImpl.updateOrderHistory(orderHistory);
		
//		orderHistoryDaoImpl.deleteOrderHistory(2);
		
		List<OrderHistory> getallOrderHistory = orderHistoryDaoImpl.getallOrderHistory();
		for(OrderHistory orderHistory:getallOrderHistory) {
			System.out.println(orderHistory);
		}
	}

}
