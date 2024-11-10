package com.onlinebookstore.dao;

import java.util.List;

import com.onlinebookstore.model.Cart;

public interface CartDao {

	boolean addToCart(Cart cart);
	
	List<Cart> showCart(String cartEmail);
	
	boolean deleteFromCart(int cartId);
}
