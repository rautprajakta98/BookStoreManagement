package com.onlinebookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookstore.model.Book;
import com.onlinebookstore.model.Category;
import com.onlinebookstore.model.Publisher;
import com.onlinebookstore.utility.ObjectsUtility;

public class BookDaoImpl implements BookDao {

	Connection con = ObjectsUtility.getDbConnection();

	@Override
	public boolean addBook(Book book) {
		try {

			PreparedStatement ps = con.prepareStatement(
					"insert into Book(bookName, bookAuthor, bookPrice, bookPublisher, bookQuantity, bookCategory, bookdesc) values(?,?,?,?,?,?,?)");

			ps.setString(1, book.getBookName());
			ps.setString(2, book.getBookAuthor());
			ps.setDouble(3, book.getBookPrice());
			ps.setString(4, book.getBookPublisher());
			ps.setInt(5, book.getBookQuantity());
			ps.setString(6, book.getBookCategory());
			ps.setString(7, book.getBookDesc());

			int isAdded = ps.executeUpdate();

			if (isAdded != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBook(Book book) {
		try {
			PreparedStatement ps = con.prepareStatement("update Book set bookName=?, bookAuthor=?,"
					+ "bookPrice=?, bookPublisher=?, bookQuantity=?, bookCategory=?, bookDesc=? where bookId=?");

			ps.setString(1, book.getBookName());
			ps.setString(2, book.getBookAuthor());
			ps.setDouble(3, book.getBookPrice());
			ps.setString(4, book.getBookPublisher());
			ps.setInt(5, book.getBookQuantity());
			ps.setString(6, book.getBookCategory());
			ps.setString(7, book.getBookDesc());
			ps.setInt(8, book.getBookId());
			int x = ps.executeUpdate();
			if (x != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean deleteBook(int bookId) {

		try {
			PreparedStatement ps = con.prepareStatement("delete from Book where bookId=?");

			ps.setInt(1, bookId);

			int x = ps.executeUpdate();

			if (x != 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> bookList = new ArrayList<Book>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from Book");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b1 = new Book();
				b1.setBookId(rs.getInt("bookId"));
				b1.setBookName(rs.getString("bookName"));
				b1.setBookAuthor(rs.getString("bookAuthor"));
				b1.setBookPrice(rs.getInt("bookPrice"));
				b1.setBookPublisher(rs.getString("bookPublisher"));
				b1.setBookQuantity(rs.getInt("bookQuantity"));
				b1.setBookCategory(rs.getString("bookCategory"));
				b1.setBookImg(rs.getString("bookImg"));
				b1.setBookDesc(rs.getString("bookDesc"));
				bookList.add(b1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public Book getBookById(int bookId) {
		Book b = new Book();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Book where bookId=?");

			ps.setInt(1, bookId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookAuthor(rs.getString(3));
				b.setBookPrice(rs.getInt(4));
				b.setBookPublisher(rs.getString(5));
				b.setBookQuantity(rs.getInt(6));
				b.setBookCategory(rs.getString(7));
				b.setBookImg(rs.getString(8));
				b.setBookDesc(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;

	}

	@Override
	public List<Book> getBookByName(String bookName) {
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Book where bookName like ?");

			ps.setString(1, bookName+'%');
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookAuthor(rs.getString(3));
				b.setBookPrice(rs.getDouble(4));
				b.setBookPublisher(rs.getString(5));
				b.setBookQuantity(rs.getInt(6));
				b.setBookCategory(rs.getString(7));
				b.setBookImg(rs.getString(8));
				b.setBookDesc(rs.getString(9));
				bookList.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByCategory(String bookCategory) {

		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Book where bookCategory=?");

			ps.setString(1, bookCategory);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookAuthor(rs.getString(3));
				b.setBookPrice(rs.getDouble(4));
				b.setBookPublisher(rs.getString(5));
				b.setBookQuantity(rs.getInt(6));
				b.setBookCategory(rs.getString(7));
				b.setBookImg(rs.getString(8));
				b.setBookDesc(rs.getString(9));
				bookList.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> category = new ArrayList<Category>();

		try {
			PreparedStatement ps = con.prepareStatement("select distinct bookCategory from Book");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category2 = new Category();
				category2.setCategoryName(rs.getString(1));
				category.add(category2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return category;
	}

	@Override
	public List<Book> getBookByPublisher(String bookPublisher) {
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Book where bookPublisher=?");

			ps.setString(1, bookPublisher);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookAuthor(rs.getString(3));
				b.setBookPrice(rs.getDouble(4));
				b.setBookPublisher(rs.getString(5));
				b.setBookQuantity(rs.getInt(6));
				b.setBookCategory(rs.getString(7));
				b.setBookImg(rs.getString(8));
				b.setBookDesc(rs.getString(9));
				bookList.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public List<Publisher> getAllPublisher() {
		List<Publisher> publisherList = new ArrayList<Publisher>();

		try {
			PreparedStatement ps = con.prepareStatement("select distinct bookPublisher from Book");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Publisher publisher = new Publisher();
				publisher.setPublisherName(rs.getString(1));
				publisherList.add(publisher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return publisherList;
	}

	@Override
	public int getLastAddedBookId() {

		int bookId = 0;

		try {
			PreparedStatement ps = con.prepareStatement("select bookId from book order by bookId desc limit 1");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bookId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookId;
	}

	@Override
	public boolean updateImageById(int bookId, String bookImg) {

		try {
			PreparedStatement ps = con.prepareStatement("update Book set bookImg=? where bookId=?");

			ps.setString(1, bookImg.trim());
			ps.setInt(2, bookId);
			int x = ps.executeUpdate();
			if (x != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
