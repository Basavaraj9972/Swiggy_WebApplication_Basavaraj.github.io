package com.tap.daoImp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDao;
import com.tap.model.Restaurant;


public class RestaurantDaoImpl implements RestaurantDao {
	 Connection con = null;
	
	static String INSERT_QUERY ="insert into `restaurant`(`name`,`imagePath`,`rating`,`eta`,`cuisinType`,`address`,`isActive`,`restaurantOwnId`) values(?,?,?,?,?,?,?,?)";
	static String SELECT_QUERY ="select * from `restaurant` where `restaurantId` = ?";
	static String UPDATE_QUERY ="update `restaurant` set `name`=?,`imagePath`=?,`rating`=?,`eta`=?,`cuisinType`=?,`address`=?,`isActive`=?,`restaurantOwnId`=? where `restaurantId`=?";
	static String DELETE_QUERY ="delete from `restaurant` where `restaurantId`=?";
	static String SELECT_ALL_QUERY ="select * from `restaurant`";
	static String SELECT_ALL_TOP_QUERY ="select * from `restaurant` where `rating` >= 4.4";
	
	public RestaurantDaoImpl() {
		try {
			String url ="jdbc:mysql://localhost:3306/tapfoods";
			String username="root";
			String password="root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class is loades Successfuly");
			con = DriverManager.getConnection(url,username,password);
			if(con!=null) {
				System.out.print("connection is success");
			}else {
				System.out.println("Connection not established");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addRestaurant(Restaurant restaurant) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getImagePath());
			pstmt.setFloat(3, restaurant.getRating());
			pstmt.setInt(4,restaurant.getEta());
			pstmt.setString(5, restaurant.getCuisinType());
			pstmt.setString(6, restaurant.getAddress());
			pstmt.setBoolean(7, restaurant.isActive());
			pstmt.setInt(8, restaurant.getRestaurantOwnId());
			int i = pstmt.executeUpdate();
			System.out.println(i);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Restaurant getRestaurant(int restaurantId) {
		PreparedStatement pstmt=null;
		Restaurant restaurant=null;
		try {
			pstmt = con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, restaurantId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String imagePath = rs.getString("imagePath");
				float rating = rs.getFloat("rating");
				int eta = rs.getInt("eta");
				String cuisinType = rs.getString("cuisinType");
				String address = rs.getString("address");
				 Boolean isActive = rs.getBoolean("isActive");
				int restaurantOwnId = rs.getInt("restaurantOwnId");
				restaurant = new Restaurant(restaurantId,name,imagePath,rating,eta,cuisinType,address,isActive,restaurantOwnId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return restaurant;
	}
	String UPDATE_QUERY1 ="update `restaurant` set `name`=?,`imagePath`=?,`rating`=?,`eta`=?,`cuisinType`=?,`address`=?,`isActive`=?,`restaurantOwnId`=? where `restaurantId`=?";
	@Override
	public void updateRestaurant(Restaurant restaurant) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getImagePath());
			pstmt.setFloat(3, restaurant.getRating());
			pstmt.setInt(4, restaurant.getEta());
			pstmt.setString(5, restaurant.getCuisinType());
			pstmt.setString(6, restaurant.getAddress());
			pstmt.setBoolean(7, restaurant.isActive());
			pstmt.setInt(8, restaurant.getRestaurantOwnId());
			pstmt.setInt(9, restaurant.getRestaurantId());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteRestaurant(int restaurantId) {
		PreparedStatement pstmt =null;
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, restaurantId);
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Restaurant> getAllRestaurant() {
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		Statement stmt =null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			while(rs.next()) {
				int restaurantId = rs.getInt("restaurantId");
				String name = rs.getString("name");
				String imagePath = rs.getString("imagePath");
				float rating = rs.getFloat("rating");
				int eta = rs.getInt("eta");
				String cuisinType = rs.getString("cuisinType");
				String address = rs.getString("address");
				boolean isActive = rs.getBoolean("isActive");
				int restaurantOwnId = rs.getInt("restaurantOwnId");
				Restaurant restaurant = new Restaurant(restaurantId,name,imagePath,rating,eta,cuisinType,address,isActive,restaurantOwnId);
				list.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public List<Restaurant> getAll_Top_Restaurant() {
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		Statement stmt =null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_TOP_QUERY);
			while(rs.next()) {
				int restaurantId = rs.getInt("restaurantId");
				String name = rs.getString("name");
				String imagePath = rs.getString("imagePath");
				float rating = rs.getFloat("rating");
				int eta = rs.getInt("eta");
				String cuisinType = rs.getString("cuisinType");
				String address = rs.getString("address");
				boolean isActive = rs.getBoolean("isActive");
				int restaurantOwnId = rs.getInt("restaurantOwnId");
				Restaurant restaurant = new Restaurant(restaurantId,name,imagePath,rating,eta,cuisinType,address,isActive,restaurantOwnId);
				list.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
