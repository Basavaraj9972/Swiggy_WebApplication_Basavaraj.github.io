package com.tap.dao;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDao {
	public void addRestaurant(Restaurant restaurant);
	public Restaurant getRestaurant(int restaurantId);
	public void updateRestaurant(Restaurant restaurant);
	public void deleteRestaurant(int restaurantId);
	public List<Restaurant> getAllRestaurant();
	public List<Restaurant> getAll_Top_Restaurant();
}
