package com.tap.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemsDao;
import com.tap.model.OrderItems;

public class OrderItemsDaoImpl implements OrderItemsDao {
	String url ="jdbc:mysql://localhost:3306/tapfoods";
	String username="root";
	String password="root";
	Connection con=null;
	String INSERT_QUERY ="insert into `orderitems` (`userId`, `menuId`, `itemName`, `quantity`, `price`,`orderId_item`) values(?,?,?,?,?,?)";
	String SELECT_QUERY ="select * from `orderitems` where `orderItemId`=?";
	String UPDATE_QUERY ="update `orderitems` set `userId`=?, `menuId`=?, `itemName`=?, `quantity`=?, `price`=?,`orderId_item`=? where `orderItemId`=?" ;
	String DELETE_QUERY ="delete from `orderitems` where `orderItemId`=?";
	String SELECT_ALL_QUERY="select * from `orderitems`";
	String SELECT_ALL_QUERY_THROUGH_USER_ID="select * from `orderitems` where `userId`=?";
	String SELECT_ALL_QUERY_THROUGH_ORDER_ID="select * from `orderitems` where `orderId_item`=?";
//	orderItemId, userId, menuId, itemName, quantity, price, orderId_item
	public OrderItemsDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class is loaded");
			con = DriverManager.getConnection(url,username,password);
			System.out.println("connection is established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addOrderItems(OrderItems orderItems) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setInt(1, orderItems.getUserId());
			pstmt.setInt(2, orderItems.getMenuId());
			pstmt.setString(3, orderItems.getItemName());
			pstmt.setInt(4, orderItems.getQuantity());
			pstmt.setFloat(5, orderItems.getPrice());
			pstmt.setString(6, orderItems.getOrderId_item());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public OrderItems getOrderItems(int orderItemId) {
		PreparedStatement pstmt = null;
		OrderItems orderItems = null;
		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, orderItemId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("userId");
				int menuId = rs.getInt("menuId");
				String itemName = rs.getString("itemName");
				int quantity = rs.getInt("quantity");
				float price = rs.getFloat("price");
				String orderId_item = rs.getString("orderId_item");
				orderItems = new OrderItems(orderItemId,userId,menuId,itemName,quantity,price,orderId_item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderItems;
	}
	@Override
	public void updateOrderItems(OrderItems orderItems) {
//		orderItemId, userId, menuId, itemName, quantity, price, orderId_item
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1, orderItems.getUserId());
			pstmt.setInt(2, orderItems.getMenuId());
			pstmt.setString(3, orderItems.getItemName());
			pstmt.setInt(4, orderItems.getQuantity());
			pstmt.setFloat(5, orderItems.getPrice());
			pstmt.setInt(6, orderItems.getOrderItemId());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderItems(int orderItemId) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, orderItemId);
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<OrderItems> getAllOrderItems() {
		OrderItems orderItems = null;
		ArrayList<OrderItems> list = new ArrayList<OrderItems>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			while(rs.next()) {
				int orderItemId = rs.getInt("orderItemId");
				int userId = rs.getInt("userId");
				int menuId = rs.getInt("menuId");
				String itemName = rs.getString("itemName");
				int quantity = rs.getInt("quantity");
				float price = rs.getFloat("price");
				String orderId_item = rs.getString("orderId_item");
				orderItems = new OrderItems(orderItemId,userId,menuId,itemName,quantity,price,orderId_item);
				list.add(orderItems);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
     @Override
    public List<OrderItems> getAllOrderItemsThroughUserId(int userId) {
    	 PreparedStatement pstmt = null;
    	OrderItems orderItems = null;
 		ArrayList<OrderItems> list = new ArrayList<OrderItems>();
 		try {
 			pstmt = con.prepareStatement(SELECT_ALL_QUERY_THROUGH_USER_ID);
 			pstmt.setInt(1, userId);
 			ResultSet rs = pstmt.executeQuery();
 			while(rs.next()) {
 				int orderItemId = rs.getInt("orderItemId");
 				int menuId = rs.getInt("menuId");
 				String itemName = rs.getString("itemName");
 				int quantity = rs.getInt("quantity");
 				float price = rs.getFloat("price");
 				String orderId_item = rs.getString("orderId_item");
 				orderItems = new OrderItems(orderItemId,userId,menuId,itemName,quantity,price,orderId_item);
 				list.add(orderItems);
 			}
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return list;
    }
     @Override
    public List<OrderItems> getAllOrderItemsThroughOrderId(String orderId) {
    	 PreparedStatement pstmt = null;
     	OrderItems orderItems = null;
  		ArrayList<OrderItems> list = new ArrayList<OrderItems>();
  		try {
  			pstmt = con.prepareStatement(SELECT_ALL_QUERY_THROUGH_ORDER_ID);
  			pstmt.setString(1, orderId);
  			ResultSet rs = pstmt.executeQuery();
  			while(rs.next()) {
  				int orderItemId = rs.getInt("orderItemId");
  				int userId = rs.getInt("userId");
  				int menuId = rs.getInt("menuId");
  				String itemName = rs.getString("itemName");
  				int quantity = rs.getInt("quantity");
  				float price = rs.getFloat("price");
  				orderItems = new OrderItems(orderItemId,userId,menuId,itemName,quantity,price,orderId);
  				list.add(orderItems);
  			}
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		return list;
    }
	
}
