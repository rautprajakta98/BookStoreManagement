package com.onlinebookstore.model;

public class Cart {

	private int cartId;
	private int bookId;
	private int quantity;
	private String customerEmailId;
	private String bookName;
	private double bookPrice;

	public int getCartId() {
		return cartId;
	}

	public int getBookId() {
		return bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public String getBookName() {
		return bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookId=" + bookId + ", quantity=" + quantity + ", customerEmailId="
				+ customerEmailId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}

}
