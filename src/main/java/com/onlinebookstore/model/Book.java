package com.onlinebookstore.model;

public class Book {

	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	private String bookPublisher;
	private int bookQuantity;
	private String bookCategory;
	private String bookImg;
	private String bookDesc;
	
	public int getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public String getBookImg() {
		return bookImg;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPrice="
				+ bookPrice + ", bookPublisher=" + bookPublisher + ", bookQuantity=" + bookQuantity + ", bookCategory="
				+ bookCategory + ", bookImg=" + bookImg + ", bookDesc=" + bookDesc + "]";
	}
	
	
}
