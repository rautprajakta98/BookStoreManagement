package com.onlinebookstore.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import com.onlinebookstore.model.Book;
import com.onlinebookstore.service.BookService;
import com.onlinebookstore.utility.ObjectsUtility;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BookController extends HttpServlet {

	BookService bookService = ObjectsUtility.getBookService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String frompage = request.getParameter("fromPage");

		if (frompage.equalsIgnoreCase("allBook")) {
			List<Book> books = bookService.getAllBook();

			request.setAttribute("allBook", books);

			RequestDispatcher rd = request.getRequestDispatcher("ShowAllBook.jsp");
			rd.forward(request, response);
		} else if (frompage.equalsIgnoreCase("deleteBook")) {
			int bookId = Integer.valueOf(request.getParameter("bookId"));

			boolean isDeleted = bookService.deleteBook(bookId);

			if (isDeleted) {
				List<Book> books = bookService.getAllBook();

				request.setAttribute("allBook", books);

				RequestDispatcher rd = request.getRequestDispatcher("ShowAllBook.jsp");
				rd.forward(request, response);
			}
		} else if (frompage.equalsIgnoreCase("updateBook")) {
			int bookId = Integer.valueOf(request.getParameter("bookId"));

			Book book = bookService.getBookById(bookId);
			request.setAttribute("singleBook", book);

			RequestDispatcher rd = request.getRequestDispatcher("UpdateBook.jsp");
			rd.forward(request, response);
		}
		else if(frompage.equalsIgnoreCase("detail"))
		{
			int bookId=Integer.valueOf(request.getParameter("bookId"));//null string
       		Book book=bookService.getBookById(bookId);
       		request.setAttribute("viewSinglebook", book);
       		RequestDispatcher rd=request.getRequestDispatcher("ViewBookDetails.jsp");
       		rd.forward(request, response);
		}
		else if(frompage.equalsIgnoreCase("searchCategory"))
		{
			String category=request.getParameter("category");
			List<Book> books=bookService.getBookByCategory(category);
			
			request.setAttribute("allBook", books);
			request.setAttribute("isSearch", true);
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else if(frompage.equalsIgnoreCase("searchPublisher"))
		{
			String publisher=request.getParameter("publisher");
			List<Book> books=bookService.getBookByPublisher(publisher);
			
			request.setAttribute("allBook", books);
			request.setAttribute("isSearch", true);
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String frompage = request.getParameter("fromPage");

		BookService bookService = ObjectsUtility.getBookService();

		if (frompage.equalsIgnoreCase("addbook")) {
			String bookName = request.getParameter("bookName");

			String bookAuthor = request.getParameter("bookAuthor");

			Double bookPrice = Double.valueOf(request.getParameter("bookPrice"));

			String bookPublisher = request.getParameter("bookPublisher");

			Integer bookQuantity = Integer.valueOf(request.getParameter("bookQuantity"));

			String bookCategory = request.getParameter("bookCategory");

			String bookDescription = request.getParameter("bookDescription");

			Book b = new Book();

			b.setBookName(bookName);
			b.setBookAuthor(bookAuthor);
			b.setBookPrice(bookPrice);
			b.setBookPublisher(bookPublisher);
			b.setBookQuantity(bookQuantity);
			b.setBookCategory(bookCategory);
			b.setBookDesc(bookDescription);

			boolean isAdded = bookService.addBook(b);

			if (isAdded) {
				int bookId = bookService.getLastAddedBookId();
				
				HttpSession session = request.getSession();
				session.setAttribute("lastBookId", bookId);
				response.sendRedirect("UploadImage.jsp");
			} else {
				System.out.println("Failed");
			}

		} else if (frompage.equalsIgnoreCase("updateBook")) {

			int bookId = Integer.valueOf(request.getParameter("bookId"));

			String bookName = request.getParameter("bookName");
			String bookAuthor = request.getParameter("bookAuthor");
			Double bookPrice = Double.valueOf(request.getParameter("bookPrice"));
			String bookPublisher = request.getParameter("bookPublisher");
			Integer bookQuantity = Integer.valueOf(request.getParameter("bookQuantity"));
			String bookCategory = request.getParameter("bookCategory");
			String bookDesc = request.getParameter("bookDescription");

			Book book = new Book();
			book.setBookId(bookId);
			book.setBookName(bookName);
			book.setBookAuthor(bookAuthor);
			book.setBookPrice(bookPrice);
			book.setBookPublisher(bookPublisher);
			book.setBookQuantity(bookQuantity);
			book.setBookCategory(bookCategory);
			book.setBookDesc(bookDesc);

			boolean isUpdated = bookService.updateBook(book);

			if (isUpdated) {
				List<Book> books = bookService.getAllBook();


				RequestDispatcher rd = request.getRequestDispatcher("ShowAllBook.jsp");
				request.setAttribute("allBook", books);
				rd.forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("Failed");
			}
		}if (frompage.equalsIgnoreCase("searchBook")) {
			
		String searchkey=request.getParameter("searchkey");
		List<Book> books=bookService.getBookByName(searchkey);
		request.setAttribute("allBook", books);
		request.setAttribute("isSearch", true);
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
				
		
		}
	}
}
