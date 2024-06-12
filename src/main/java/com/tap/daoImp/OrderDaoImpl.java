package com.tap.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDao;
import com.tap.model.Order;

public class OrderDaoImpl implements OrderDao {
	static String url ="jdbc:mysql://localhost:3306/tapfoods";
	static String username="root";
	static String password="root";
	static Connection con = null;  
	static String INSERT_QUERY ="insert into `order` (`orderId`,`restaurantId_och`, `userId_o`, `totalAmount`, `modeOfPayment`,`status`,`address`) values(?,?,?,?,?,?,?)";
	static String SELECT_QUERY ="select * from `order` where `orderId`=?";
	static String UPDATE_QUERY ="update `order` set `restaurantId_och`=?, `userId_o`=?, `totalAmount`=?, `modeOfPayment`=?, `status`=?,`address`=? where `orderId`=?";
	static String DELETE_QUERY ="delete from `order` where `orderId`=?";
	static String SELECT_ALL_QUERY ="select * from `order`";
//	orderId, restaurantId_och, userId_o, totalAmount, modeOfPayment, status, address, orderDateTime
	public OrderDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class is loaded");
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection is Establised");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addOrder(Order order) {
		PreparedStatement pstmt =null;
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1, order.getOrderId());
			pstmt.setInt(2, order.getRestaurantId_och());
			pstmt.setInt(3, order.getUserId_o());
			pstmt.setFloat(4, order.getTotalAmount());
			pstmt.setString(5, order.getModeOfPayment());
			pstmt.setString(6, order.getStatus());
			pstmt.setString(7, order.getAddress());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Order getOrder(String orderId) {
		PreparedStatement pstmt =null;
		Order order=null;
		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			pstmt.setString(1, orderId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//orderId, restaurantId_och, userId_o, totalAmount, modeOfPayment, status, address, orderDateTime
				int restaurantId_och = rs.getInt("restaurantId_och");
				int userId = rs.getInt("userId_o");
				float totalAmount = rs.getInt("totalAmount");
				String modeOfPayment = rs.getString("modeOfPayment");
				String status = rs.getString("status");
				String address = rs.getString("address");
				order = new Order(orderId,restaurantId_och,userId,totalAmount,modeOfPayment,status,address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	@Override
	public void updateOrder(Order order) {
		PreparedStatement pstmt =null;
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1, order.getRestaurantId_och());
			pstmt.setInt(2, order.getUserId_o());
			pstmt.setFloat(3, order.getTotalAmount());
			pstmt.setString(4, order.getModeOfPayment());
			pstmt.setString(5, order.getStatus());
			pstmt.setString(6, order.getAddress());
			pstmt.setString(7, order.getOrderId());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteOrder(String orderId) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setString(1, orderId);
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Order> getAllOrder() {
		Order order = null;
		ArrayList<Order> list = new ArrayList<Order>();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			while(rs.next()) {
				//orderId, restaurantId_och, userId_o, totalAmount, modeOfPayment, status, address, orderDateTime
				String orderId = rs.getString("orderId");
				int restaurantId_och = rs.getInt("restaurantId_och");
				int userId = rs.getInt("userId_o");
				float totalAmount = rs.getInt("totalAmount");
				String modeOfPayment = rs.getString("modeOfPayment");
				String status = rs.getString("status");
				String address = rs.getString("address");
				order = new Order(orderId,restaurantId_och,userId,totalAmount,modeOfPayment,status,address);
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
