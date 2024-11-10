package com.onlinebookstore.service;

import java.util.List;

import com.onlinebookstore.model.Cart;

public interface CartService {

	boolean addToCart(Cart cart);
	
	List<Cart> showCart(String cartEmail);
	
	boolean deleteFromCart(int cartId);
}
