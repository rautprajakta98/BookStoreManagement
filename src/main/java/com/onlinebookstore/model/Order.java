package com.onlinebookstore.model;

public class Order {

	private int orderId;
	private String orderStatus;
	private String bookName;
	private int quantity;
	private double totalBill;
	private String userEmailId;


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public double getTotalBill() {
		return totalBill;
	}

	

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", bookName=" + bookName + ", quantity="
				+ quantity + ", totalBill=" + totalBill + ", userEmailId=" + userEmailId + "]";
	}

	

	

}
