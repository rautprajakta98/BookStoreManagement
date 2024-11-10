package com.onlinebookstore.controller;

import java.io.IOException;
import java.util.List;

import com.onlinebookstore.model.Book;
import com.onlinebookstore.model.Cart;
import com.onlinebookstore.model.Users;
import com.onlinebookstore.service.BookService;
import com.onlinebookstore.service.CartService;
import com.onlinebookstore.utility.Constant;
import com.onlinebookstore.utility.ObjectsUtility;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	BookService bookService = ObjectsUtility.getBookService();
	CartService cartService = ObjectsUtility.getCartService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String frompage = request.getParameter("frompage");
		if (frompage.equalsIgnoreCase("buyNow")) {
			int bookId = Integer.valueOf(request.getParameter("bookId"));
			Book book = bookService.getBookById(bookId);

			Cart cart = new Cart();
			cart.setBookId(book.getBookId());
			cart.setQuantity(1);
 
			HttpSession session=request.getSession();
			Users users=(Users)session.getAttribute(Constant.LOGEDINUSER);
			
			cart.setCustomerEmailId(users.getUserEmailId());
			cart.setBookName(book.getBookName());
			cart.setBookPrice(book.getBookPrice());
			
			boolean isCartAdded=cartService.addToCart(cart);
			if(isCartAdded)
			{
				response.sendRedirect("index.jsp");
			}
		}
		else if(frompage.equalsIgnoreCase("allCart")) {
			String userEmailId=request.getParameter("userEmailId");
			
			List<Cart> carts=cartService.showCart(userEmailId);
			
			request.setAttribute("allCart", carts);
			RequestDispatcher rd=request.getRequestDispatcher("ShowAllCart.jsp");
			rd.forward(request, response);
		}
		else if (frompage.equalsIgnoreCase("deleteCart")) {//pending
			int cartId = Integer.valueOf(request.getParameter("cartId"));

			boolean isDeleted =cartService.deleteFromCart(cartId);

			if (isDeleted) {
				List<Cart> carts = cartService.showCart("cartId");

				request.setAttribute("allCart", carts);

				RequestDispatcher rd = request.getRequestDispatcher("ShowAllCart.jsp");
				rd.forward(request, response);
			}
			
			}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String frompage = request.getParameter("frompage");

	}
}
