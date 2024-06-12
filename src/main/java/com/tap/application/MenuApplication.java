package com.tap.application;

import java.util.Iterator;
import java.util.List;

import com.tap.daoImp.MenuDaoImpl;
import com.tap.model.Menu;

public class MenuApplication {

	public static void main(String[] args) {
		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		 
//		Menu menu = new Menu(4,"Banarasi ",259,"Authentic Dessert.","age path",true,4.5f,2);
//		menuDaoImpl.addMenu(menu);
//		Menu menu2 = menuDaoImpl.getMenu(4);
//		System.out.println(menu2);
		
//		menuDaoImpl.deleteMenu(4);
		
//		menu2.setImagepath("Aloo Palak Thali Meal image");
//		menuDaoImpl.updateMenu(menu2);
		
		List<Menu> allMenu = menuDaoImpl.getAllMenu();
		for(Menu menu :allMenu) {
			System.out.println(menu);
		}
	}

}
