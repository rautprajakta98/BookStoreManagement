package com.onlinebookstore.dao;

import java.util.List;

import com.onlinebookstore.model.Order;

public interface orderDao {
	boolean placeOrder(String customerUserEmail, List<String> bookNames, List<String> bookPrice, List<String> liBookQuantity);
	List<Order> getAllOrder(String userEmailId);
	boolean clearCart(String customerUserEmail);
	String checkOrderStatus(int orderId);}
