package com.tap.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDao;
import com.tap.model.Menu;
public class MenuDaoImpl implements MenuDao {
	 
	static Connection con;
	static String INSERT_QUERY = "insert into `menu`(`menuId`,`name`,`price`,`description`,`imagepath`,`isAvailable`,`rating`,`restaurantId`) values(?,?,?,?,?,?,?,?)"; 
	static String SELECT_QUERY_BY_MENU_ID ="select * from `menu` where `menuId`=?";
	static String SELECT_QUERY_BY_RESTARANT_ID="select * from `menu` where `restaurantId`=?";
	static String UPDATE_QUERY ="update `menu` set `name`=?,`price`=?,`description`=?,`imagepath`=?,`isAvailable`=?,`rating`=?,`restaurantId`=? where `menuId`=?";
	static String DELETE_QUERY="delete from `menu` where `menuId`=?";
	static String SELECT_ALL_QUERY ="select * from `menu`";
	
	public MenuDaoImpl() {
		try {
			String url ="jdbc:mysql://localhost:3306/tapfoods";
			String username ="root";
			String password="root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class loaded Successfully");
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Database connection is successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addMenu(Menu menu) {
		PreparedStatement pstmt= null;
		try {
			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setInt(1, menu.getMenuId());
			pstmt.setString(2, menu.getName());
			pstmt.setFloat(3, menu.getPrice());
			pstmt.setString(4, menu.getDescription());
			pstmt.setString(5, menu.getImagepath());
			pstmt.setBoolean(6, menu.isAvailable());
			pstmt.setFloat(7, menu.getRating());
			pstmt.setInt(8, menu.getRestaurantId());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Menu getMenu(int menuId) {
		PreparedStatement pstmt= null;
		Menu menu = null;
		try {
			pstmt = con.prepareStatement(SELECT_QUERY_BY_MENU_ID);
			pstmt.setInt(1, menuId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String description = rs.getString("description");
				String imagepath = rs.getString("imagepath");
				boolean isAvailable = rs.getBoolean("isAvailable");
				float rating = rs.getFloat("rating");
				int restaurantId = rs.getInt("restaurantId");
				menu = new Menu(menuId,name,price,description,imagepath,isAvailable,rating,restaurantId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}
	@Override
	public void updateMenu(Menu menu) {
		PreparedStatement pstmt= null;
		try {
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, menu.getName());
			pstmt.setFloat(2, menu.getPrice());
			pstmt.setString(3, menu.getDescription());
			pstmt.setString(4, menu.getImagepath());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setFloat(6, menu.getRating());
			pstmt.setInt(7, menu.getRestaurantId());
			pstmt.setInt(8, menu.getMenuId());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteMenu(int menuId) {
		PreparedStatement pstmt= null;
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, menuId);
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Menu> getAllMenu() {
		Menu menu =null;
		ArrayList<Menu> list = new ArrayList<Menu>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			while(rs.next()) {
				int menuId = rs.getInt("menuId");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String description = rs.getString("description");
				String imagepath = rs.getString("imagepath");
				boolean isAvailable = rs.getBoolean("isAvailable");
				float rating = rs.getFloat("rating");
				int restaurantId = rs.getInt("restaurantId");
				menu = new Menu(menuId,name,price,description,imagepath,isAvailable,rating,restaurantId);
				list.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Menu> getByRestauarantId(int restaurantId) {
		ArrayList<Menu> list = new ArrayList<Menu>();
		PreparedStatement pstmt= null;
		Menu menu = null;
		try {
			pstmt = con.prepareStatement(SELECT_QUERY_BY_RESTARANT_ID);
			pstmt.setInt(1, restaurantId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int menuId = rs.getInt("menuId");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				String description = rs.getString("description");
				String imagepath = rs.getString("imagepath");
				boolean isAvailable = rs.getBoolean("isAvailable");
				float rating = rs.getFloat("rating");
				menu = new Menu(menuId,name,price,description,imagepath,isAvailable,rating,restaurantId);
				list.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}


	
