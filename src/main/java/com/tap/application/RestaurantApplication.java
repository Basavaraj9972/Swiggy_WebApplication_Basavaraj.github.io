package com.tap.application;

import java.util.ArrayList;
import java.util.List;

import com.tap.daoImp.RestaurantDaoImpl;
import com.tap.model.Restaurant;

public class RestaurantApplication {

	public static void main(String[] args) {
		 RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
//		Restaurant restaurant = new Restaurant();
//        Duration minTime = Duration.ofMinutes(30);
//        Duration maxTime = Duration.ofMinutes(35);
//
//        // Usage example
//        System.out.println("Estimated time range: " + minTime + " - " + maxTime);
		
//		 Restaurant restaurant = new Restaurant(3,"Rajani","res_image_path2",3.4f,35,"South India Meals","BTM Layout",false,4);
//		 restaurantDaoImpl.addRestaurant(restaurant);
		
//		Restaurant restaurant2 = restaurantDaoImpl.getRestaurant(1);
//		System.out.println(restaurant2);
		 
//		 restaurantDaoImpl.updateRestaurant(restaurant);

//		 restaurantDaoImpl.deleteRestaurant(3);
		 
		List<Restaurant> list = restaurantDaoImpl.getAllRestaurant();
		 for(Restaurant restaurant1 :list) {
			 System.out.println(restaurant1);
		 }
		 
	}

}
