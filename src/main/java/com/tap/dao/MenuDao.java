package com.tap.dao;

import java.util.List;

import com.tap.model.Menu;

public interface MenuDao {

	public void addMenu(Menu menu);
	public Menu getMenu(int menuId);
	public void updateMenu(Menu menu);
	public void deleteMenu(int menuId);
	public List<Menu> getAllMenu();
	public List<Menu> getByRestauarantId(int restaurantId);
}
