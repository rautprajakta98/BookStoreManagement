package com.onlinebookstore.service;

import java.util.List;

import com.onlinebookstore.model.Order;

public interface orderService {
	boolean placeOrder(String customerUserEmail, String bookPrices, String bookNames, String[] bookQuantity);
	List<Order> getAllOrder(String userEmailId);
	boolean clearCart(String customerUserEmail);
	String checkOrderStatus(int orderId);
}
