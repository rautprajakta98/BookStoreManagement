package com.onlinebookstore.service;

import java.util.List;

import com.onlinebookstore.model.Book;
import com.onlinebookstore.model.Category;
import com.onlinebookstore.model.Publisher;

public interface BookService {

	boolean addBook(Book book);
	boolean updateBook(Book book);
	boolean deleteBook(int bookId);
	
	List<Book> getAllBook();
	Book getBookById(int bookId);
	
	List<Book> getBookByName(String bookName);
	
	List<Book> getBookByCategory(String bookCategory);
	List<Category> getAllCategory();
	
	List<Book> getBookByPublisher(String bookPublisher);
	List<Publisher> getAllPublisher();
	
	int getLastAddedBookId();
	
	boolean updateImageById(int bookId,String bookImg);
}
