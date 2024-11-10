	package com.onlinebookstore.controller;
	
	import java.io.File;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.List;
	
	import com.onlinebookstore.model.Book;
	import com.onlinebookstore.service.BookService;
	import com.onlinebookstore.utility.ObjectsUtility;
	
	import jakarta.servlet.RequestDispatcher;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.MultipartConfig;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import jakarta.servlet.http.HttpSession;
	import jakarta.servlet.http.Part;
	
	@WebServlet("/UploadImageController")
	@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
	public class UploadImageController extends HttpServlet {
		
		BookService bookService = ObjectsUtility.getBookService();
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
	
		}
	
		private String getFileName(Part part) {
			String contentDispositionHeader = part.getHeader("content-disposition");
			String[] elements = contentDispositionHeader.split(";");
			for (String element : elements) {
				if (element.trim().startsWith("filename")) {
					return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
				}
			}
			return null;
		}
	
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String fileName = null;
			String uploadPath = "C:\\Users\\Prajakta\\OneDrive\\Desktop\\new folder\\WebOnlineBookStore\\src\\main\\webapp\\images\\";
			System.out.println(uploadPath);
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			for (Part part : request.getParts()) {
				 fileName = getFileName(part);
				part.write(uploadPath + File.separator + fileName);
			}
			
			HttpSession session = request.getSession();
			int bookId = (int)session.getAttribute("lastBookId");
			
			boolean imgUpdated = bookService.updateImageById(bookId, fileName);
			
			if(imgUpdated) {
				List<Book> books = bookService.getAllBook();
	
				
				request.setAttribute("allBook", books);
	
				RequestDispatcher rd = request.getRequestDispatcher("ShowAllBook.jsp");
				rd.forward(request, response);
				response.sendRedirect("ShowAllBook.jsp");
			}else {
				PrintWriter out = response.getWriter();
				out.println("Failed");
			}
		}
	}