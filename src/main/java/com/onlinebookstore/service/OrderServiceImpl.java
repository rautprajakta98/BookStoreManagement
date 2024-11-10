package com.onlinebookstore.service;

import java.util.List;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.onlinebookstore.dao.orderDao;
import com.onlinebookstore.model.Order;
import com.onlinebookstore.utility.ObjectsUtility;

public class OrderServiceImpl implements orderService {

orderDao orderDao = ObjectsUtility.getOrderDao();
	
	@Override
	public boolean placeOrder(String customerUserEmail, String bookPrices, String bookNames, String[] bookQuantity) {

		String[] arrBookNames = bookNames.split(",");
		String[] arrBookPrices = bookPrices.split(",");
		
		List<String> liBookName = Arrays.stream(arrBookNames)
		.filter(x -> !x.equals("null"))
		.collect(Collectors.toList());
		
		List<String> liBookPrice = Arrays.stream(arrBookPrices)
		.filter(x -> !x.equals("null"))
		.collect(Collectors.toList());
		
		List<String> liBookQuantity =  Arrays.stream(bookQuantity)
		.map(OrderServiceImpl :: setQuantity)
		.collect(Collectors.toList());
		
		boolean isOrderPlace =  orderDao.placeOrder(customerUserEmail, liBookName, liBookPrice, liBookQuantity);
		return isOrderPlace;
	}
	
	private static String setQuantity(String bookQuantity) {
		if(bookQuantity == null || bookQuantity == " " || bookQuantity == "") {
			return "1";
		}
		return bookQuantity;
	}

	@Override
	public List<Order> getAllOrder(String userEmailId) {

		return orderDao.getAllOrder(userEmailId);
	}

	@Override
	public boolean clearCart(String customerUserEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String checkOrderStatus(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
