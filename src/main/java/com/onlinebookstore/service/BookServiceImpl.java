package com.onlinebookstore.service;

import java.util.ArrayList;
import java.util.List;

import com.onlinebookstore.dao.BookDao;
import com.onlinebookstore.model.Book;
import com.onlinebookstore.model.Category;
import com.onlinebookstore.model.Publisher;
import com.onlinebookstore.utility.ObjectsUtility;

public class BookServiceImpl implements BookService {

	BookDao daoImpl = ObjectsUtility.getBookDao();

	@Override
	public boolean addBook(Book book) {
		boolean isAdded = daoImpl.addBook(book);
		if (isAdded) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateBook(Book book) {
		boolean isUpdated = daoImpl.updateBook(book);
		if (isUpdated) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteBook(int bookId) {
		boolean isDeleted = daoImpl.deleteBook(bookId);
		if (isDeleted) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> bookList = new ArrayList<Book>();
		bookList = daoImpl.getAllBook();
		return bookList;
	}

	@Override
	public Book getBookById(int bookId) {
		Book book = daoImpl.getBookById(bookId);
		return book;
	}

	@Override
	public List<Book> getBookByName(String bookName) {
		List<Book> bookList = new ArrayList<Book>();
		bookList = daoImpl.getBookByName(bookName);
		return bookList;
	}

	@Override
	public List<Book> getBookByCategory(String bookCategory) {
		List<Book> bookList = new ArrayList<Book>();
		bookList = daoImpl.getBookByCategory(bookCategory);
		return bookList;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> bookCategory = new ArrayList<Category>();
		bookCategory = daoImpl.getAllCategory();
		return bookCategory;
	}

	@Override
	public List<Book> getBookByPublisher(String bookPublisher) {
		List<Book> bookList = new ArrayList<Book>();
		bookList = daoImpl.getBookByPublisher(bookPublisher);
		return bookList;
	}

	@Override
	public List<Publisher> getAllPublisher() {
		List<Publisher> bookPubList = new ArrayList<Publisher>();
		bookPubList = daoImpl.getAllPublisher();
		return bookPubList;
	}

	@Override
	public int getLastAddedBookId() {
		int bookId = daoImpl.getLastAddedBookId();

		return bookId;
	}

	@Override
	public boolean updateImageById(int bookId, String bookImg) {
		boolean isUpdaetd = daoImpl.updateImageById(bookId, bookImg);
		if (isUpdaetd) {
			return true;
		} else {
			return false;
		}
	}

}
