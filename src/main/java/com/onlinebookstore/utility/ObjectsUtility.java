package com.onlinebookstore.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.onlinebookstore.dao.BookDao;
import com.onlinebookstore.dao.BookDaoImpl;
import com.onlinebookstore.dao.CartDao;
import com.onlinebookstore.dao.CartDaoImpl;
import com.onlinebookstore.dao.OrderDaoImpl;
import com.onlinebookstore.dao.UsersDao;
import com.onlinebookstore.dao.UsersDaoImpl;
import com.onlinebookstore.dao.orderDao;
import com.onlinebookstore.listeners.MyServletContext;
import com.onlinebookstore.service.BookService;
import com.onlinebookstore.service.BookServiceImpl;
import com.onlinebookstore.service.CartService;
import com.onlinebookstore.service.CartServiceImpl;
import com.onlinebookstore.service.OrderServiceImpl;
import com.onlinebookstore.service.UsersService;
import com.onlinebookstore.service.UsersServiceImpl;
import com.onlinebookstore.service.orderService;

public class ObjectsUtility {
	private static BookDao dao;
	private static BookService service;
	private static UsersDao customerDao;
	private static UsersService customerService;
	private static CartService cartService;
	private static CartDao cartDao;
	private static orderService orderService;
	private static orderDao orderDao;
	
	

	public static Connection getDbConnection() {
		return MyServletContext.dbConnection;
	}
	
	public static BookDao getBookDao() {
		if(dao==null) {
			dao = new BookDaoImpl();
		}
		return dao;
	}
	
	public static BookService getBookService() {
		if(service==null) {
			service = new BookServiceImpl();
		}
		return service;
	}
	
	public static UsersDao getCustomerDao() {
		if(customerDao==null) {
			customerDao = new UsersDaoImpl();
		}
		return customerDao;
	}
	
	public static UsersService getCustomerService() {
		if(customerService==null) {
			customerService = new UsersServiceImpl();
		}
		return customerService;
	}
	
	public static CartService getCartService() {
		if(cartService==null) {
			cartService = new CartServiceImpl();
		}
		return cartService;
	}
	
	public static CartDao getCartDao() {
		if(cartDao==null) {
			cartDao = new CartDaoImpl();
		}
		return cartDao;
	}

	public static orderService getOrderService() {
		if(orderService==null)
		{
			orderService=new OrderServiceImpl();
		}
		return orderService;
	}

	

	public static orderDao getOrderDao() {
		if(orderDao==null)
		{
			orderDao=new OrderDaoImpl();
		}
		return orderDao;
	}

	/*
	 * public static orderDao getOrderDao() {
		if(orderDao==null) {
			orderDao = new OrderDaoImpl();
		}
		return orderDao;
	}
	
	public static orderService getOrderService() {
		if(orderService==null) {
			orderService = new OrderServiceImpl();
		}
		return orderService;
	}	 */
	
}
