package com.onlinebookstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.catalina.User;

import com.onlinebookstore.model.Users;
import com.onlinebookstore.service.UsersService;
import com.onlinebookstore.utility.ObjectsUtility;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UsersController extends HttpServlet {

	UsersService usersService = ObjectsUtility.getCustomerService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String frompage = request.getParameter("fromPage");

		if (frompage.equalsIgnoreCase("allUser")) {

			List<Users> users = usersService.getAllUser();

			request.setAttribute("allUser", users);
			RequestDispatcher rd = request.getRequestDispatcher("ShowAllUsers.jsp");
			rd.forward(request, response);
		} else if (frompage.equalsIgnoreCase("deleteUser")) {

			Integer userId = Integer.valueOf(request.getParameter("userId"));

			boolean isDeleted = usersService.deleteUser(userId);

			if (isDeleted) {
				List<Users> users = usersService.getAllUser();

				request.setAttribute("allUser", users);
				RequestDispatcher rd = request.getRequestDispatcher("ShowAllUsers.jsp");
				rd.forward(request, response);
			}
		} else if (frompage.equalsIgnoreCase("updateUser")) {

			int userId = Integer.valueOf(request.getParameter("userId"));

			Users user = usersService.getUserById(userId);

			request.setAttribute("singleUser", user);
			RequestDispatcher rd = request.getRequestDispatcher("UpdateUser.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String frompage = request.getParameter("fromPage");

		if (frompage.equalsIgnoreCase("adduser")) {

			String userName = request.getParameter("userName");

			String userAddress = request.getParameter("userAddress");

			String userEmail = request.getParameter("userEmail");

			String userContact = request.getParameter("userContact");

			String userPassword = request.getParameter("userPassword");

			String isAdmin = request.getParameter("isAdmin");

			Users user = new Users();

			user.setUserName(userName);
			user.setUserAddress(userAddress);
			user.setUserEmailId(userEmail);
			user.setUserContactNo(userContact);
			user.setUserPassword(userPassword);

			if (isAdmin != null) {
				user.setAdmin(true);
			} else {
				user.setAdmin(false);
			}

			Boolean isAdded = usersService.addUser(user);
			if (isAdded) {
				PrintWriter out = response.getWriter();
				out.println("User Added");
			} else {
				System.out.println("Failed");
			}
		} else if (frompage.equalsIgnoreCase("updateUser")) {

			int userId = Integer.valueOf(request.getParameter("userId"));

			Users user = new Users();

			user.setUserId(userId);
			user.setUserName(request.getParameter("userName"));
			user.setUserAddress(request.getParameter("userAddress"));
			user.setUserEmailId(request.getParameter("userEmail"));
			user.setUserContactNo(request.getParameter("userContact"));
			user.setUserPassword(request.getParameter("userPassword"));
			user.setAdmin(Boolean.valueOf(request.getParameter("isAdmin")));

			boolean isUpdated = usersService.updateUser(user);

			if (isUpdated) {
				List<Users> users = usersService.getAllUser();

				request.setAttribute("allUser", users);
				RequestDispatcher rd = request.getRequestDispatcher("ShowAllUsers.jsp");
				rd.forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("Failed");
			}
		}
	}
}
