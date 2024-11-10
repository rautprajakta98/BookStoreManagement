package com.onlinebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import com.onlinebookstore.utility.ObjectsUtility;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.onlinebookstore.model.Book;
import com.onlinebookstore.model.Order;
import com.onlinebookstore.model.Users;
import com.onlinebookstore.service.CartService;
import com.onlinebookstore.service.orderService;

import com.onlinebookstore.utility.Constant;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	orderService orderService = ObjectsUtility.getOrderService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String frompage = request.getParameter("frompage");
	 if(frompage.equalsIgnoreCase("allOrders")) {
		String userEmailId=request.getParameter("userEmailId");
			List<Order> orders = orderService.getAllOrder(userEmailId);

			request.setAttribute("allOrder", orders);

			RequestDispatcher rd = request.getRequestDispatcher("ShowOrder.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String frompage = request.getParameter("frompage");

		if (frompage.equals("fromCart")) {

			String bookNames = request.getParameter("bookNames");
			String bookPrices = request.getParameter("bookPrices");
			String[] bookQuantity = request.getParameterValues("bookQuantity");

			System.out.println(Arrays.toString(bookQuantity));

			HttpSession session = request.getSession();
			Users users = (Users) session.getAttribute(Constant.LOGEDINUSER);

			boolean isOrderPlace = orderService.placeOrder(users.getUserEmailId(), bookPrices, bookNames, bookQuantity);
			System.out.println("isOrderPlace " + isOrderPlace);
			if(isOrderPlace)
			{
				List<Order> orders = orderService.getAllOrder(users.getUserEmailId());


				RequestDispatcher rd = request.getRequestDispatcher("ShowOrder.jsp");
				request.setAttribute("allOrder", orders);
				rd.forward(request, response);
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("Failed");
			}
		}
		
	}
}
