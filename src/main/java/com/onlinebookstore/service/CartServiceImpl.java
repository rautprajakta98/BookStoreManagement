package com.onlinebookstore.service;

import java.util.List;

import com.onlinebookstore.dao.CartDao;
import com.onlinebookstore.model.Cart;
import com.onlinebookstore.utility.ObjectsUtility;

public class CartServiceImpl implements CartService {

	CartDao daoImpl = ObjectsUtility.getCartDao();

	@Override
	public boolean addToCart(Cart cart) {
		boolean isAdded = daoImpl.addToCart(cart);
		if (isAdded) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Cart> showCart(String cartEmail) {
		List<Cart> cart = daoImpl.showCart(cartEmail);
		return cart;
	}

	@Override
	public boolean deleteFromCart(int cartId) {
		boolean isDeleted = daoImpl.deleteFromCart(cartId);
		if (isDeleted) {
			return true;
		} else {
			return false;
		}
	}

}
