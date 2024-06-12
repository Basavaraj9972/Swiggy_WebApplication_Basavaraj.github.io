package com.tap.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartCreator {
	Map<Integer,CartItem> cart;
	public CartCreator(){
		if(cart == null) {
			cart = new LinkedHashMap<Integer,CartItem>();
		}
	}
	public Map<Integer,CartItem> addcartCartItem(CartItem ci){
		if(cart.containsKey(ci.getItemId())) {
			CartItem cr = cart.get(ci.getItemId());
			int quantity1 =0;
			int quantity2 =0;
			int upadatedQuantity =0;
			quantity1 = cr.getQuantity();
			quantity2 = ci.getQuantity();
			if(quantity2>0) {
				upadatedQuantity = quantity1+quantity2;
				cr.setQuantity(upadatedQuantity);
			}
			else if(quantity2==0){
				upadatedQuantity = quantity1+1;
				cr.setQuantity(upadatedQuantity);
			}
			else if(quantity2>0) {
				upadatedQuantity = quantity1+quantity2;
				cr.setQuantity(upadatedQuantity);
			}
			float updatedPrice =0.0f;
			updatedPrice = upadatedQuantity * ci.getPrice();
			System.out.println(updatedPrice);
			cr.setPrice(updatedPrice);
			cart.put(ci.getItemId(), cr);
		}
		else {
			if(ci.getQuantity()==0) {
				ci.setQuantity(1);
			}else if(ci.getQuantity()>0) {
				ci.setQuantity(ci.getQuantity());
			}
			ci.setPrice(ci.getQuantity() * ci.getPrice());
			cart.put(ci.getItemId(), ci);
		}
		return cart;
	}
	public void updateCartItem(int itemId,int quantity,float price) {
		CartItem cr = cart.get(itemId);
		if(cr!=null) {
			if(quantity>0) {
				cr.setQuantity(quantity);
				cr.setPrice(quantity * price);
				System.out.println(cr.getPrice());
				cart.put(itemId, cr);
			}else if(quantity==0) {
				cr.setQuantity(1);
				cr.setPrice(price);
				cart.put(itemId, cr);
			}
		}
		System.out.println(cart.get(itemId).getQuantity());
	}
	public void deletCartItem(int itemId) {
		CartItem cr = cart.remove(itemId);
		
		System.out.println(cr);
	}
	public Map<Integer,CartItem> getAll(){
		return cart;
	}
}
