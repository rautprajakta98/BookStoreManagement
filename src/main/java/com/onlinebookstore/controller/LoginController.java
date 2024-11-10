package com.onlinebookstore.controller;

import java.io.IOException;

import java.io.PrintWriter;

import com.onlinebookstore.model.Users;
import com.onlinebookstore.service.UsersService;
import com.onlinebookstore.service.UsersServiceImpl;
import com.onlinebookstore.utility.Constant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String frompage = request.getParameter("fromPage");
		
		if(frompage.equalsIgnoreCase("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
String frompage = request.getParameter("frompage");
UsersService usersService = new UsersServiceImpl();

PrintWriter out=response.getWriter();
if (frompage.equalsIgnoreCase("login")) {
	String email = request.getParameter("userName");
	String password = request.getParameter("userPassword");
	Users users = usersService.loginUser(email, password);

	if (users != null) {
		HttpSession session = request.getSession();
		session.setAttribute(Constant.LOGEDINUSER, users);
		response.sendRedirect("index.jsp");
	} else {
		request.setAttribute("invalidDetails", "invalidDetails");
		RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
		rd.forward(request, response);
	}
		}
	}
}
