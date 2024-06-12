package com.tap.application;

import java.util.List;

import com.tap.daoImp.OrderItemsDaoImpl;
import com.tap.model.OrderItems;

public class OrderItemsApplication {

	public static void main(String[] args) {
		OrderItemsDaoImpl orderItemsDaoImpl = new OrderItemsDaoImpl();
//		OrderItems orderItems = new OrderItems(4,1,"pani Puri",1,60,4.4f);
//		orderItemsDaoImpl.addOrderItems(orderItems);
		
//		OrderItems orderItems2 = orderItemsDaoImpl.getOrderItems(3);
//		System.out.println(orderItems2);
		
//		orderItemsDaoImpl.updateOrderItems(orderItems2);
//		System.out.println(orderItems2);
		
//		orderItemsDaoImpl.deleteOrderItems(5);
		
		List<OrderItems> allOrderItems = orderItemsDaoImpl.getAllOrderItems();
		for(OrderItems orderItems1:allOrderItems) {
			System.out.println(orderItems1);
		}
		
	}

}
