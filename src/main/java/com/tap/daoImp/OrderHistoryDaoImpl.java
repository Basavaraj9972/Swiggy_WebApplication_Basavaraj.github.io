package com.tap.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderHistoryDao;
import com.tap.model.OrderHistory;

public class OrderHistoryDaoImpl implements  OrderHistoryDao{
	String url ="jdbc:mysql://localhost:3306/tapfoods";
	String username="root";
	String password="root";
	Connection con = null;  
	String INSERT_QUERY ="insert into `orderhistory` (`userId_oh`,`orderId_oh`) values(?,?)";
	String SELECT_QUERY ="select * from `orderhistory` where `orderHistoryId`=?";
	String UPDATE_QUERY ="update `orderhistory` set `orderId_oh`=?, `userId_oh`=? where `orderHistoryId`=?";
	String DELETE_QUERY ="delete from `orderhistory` where `orderHistoryId`=?";
	String SELECT_ALL_QUERY ="select * from `orderhistory`";
//	orderHistoryId, userId_oh, orderId_oh
	public OrderHistoryDaoImpl() {
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
	public void addOrderHistory(OrderHistory orderHistory) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			
			pstmt.setInt(1, orderHistory.getUserId_oh());
			pstmt.setString(2, orderHistory.getOrderId_oh());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
		PreparedStatement pstmt = null;
		OrderHistory orderHistory = null;
		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, orderHistoryId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int userId_oh = rs.getInt("userId_oh");
				String orderId_oh = rs.getString("orderId_oh");
				orderHistory = new OrderHistory(orderHistoryId,userId_oh,orderId_oh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderHistory;
	}
	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, orderHistory.getOrderId_oh());
			pstmt.setInt(2, orderHistory.getUserId_oh());
			pstmt.setInt(3, orderHistory.getOrderHistoryId());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, orderHistoryId);
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<OrderHistory> getallOrderHistory() {
		OrderHistory orderHistory = null;
		ArrayList<OrderHistory> list = new ArrayList<OrderHistory>();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			while(rs.next()) {
				int orderHistoryId = rs.getInt("orderHistoryId");
				int userId_oh = rs.getInt("userId_oh");
				String orderId_oh = rs.getString("orderId_oh");
				orderHistory = new OrderHistory(orderHistoryId,userId_oh,orderId_oh);
				list.add(orderHistory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
