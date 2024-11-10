package com.onlinebookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.onlinebookstore.model.Book;
import com.onlinebookstore.model.Order;
import com.onlinebookstore.utility.ObjectsUtility;

public class OrderDaoImpl implements orderDao {
	Connection con = ObjectsUtility.getDbConnection();
	@Override
	public boolean placeOrder(String customerUserEmail, List<String> bookNames, List<String> bookPrice,
			List<String> liBookQuantity) {

		

		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"insert into orders(orderStatus, bookName, totalBill, userEmailId, quantity) values(?,?,?,?,?)");

			for (int i = 0; i < bookNames.size(); i++) {
				String bName = bookNames.get(i);
				String bPrice = bookPrice.get(i);
				String bQuantity = liBookQuantity.get(i);

				Double totalBill = Double.valueOf(bPrice) * Double.valueOf(bQuantity);

				ps.setString(1, "Success");
				ps.setString(2, bName);
				ps.setLong(3, Math.round(totalBill));
				ps.setString(4, customerUserEmail);
				ps.setInt(5, Integer.valueOf(bQuantity));
				ps.addBatch();
			}

			int[] arr = ps.executeBatch();

			boolean isNotAdded = Arrays.stream(arr).anyMatch(x -> x == 0);
			
			if(isNotAdded) {
				con.rollback();
			}else {
				boolean isDeleted = clearCart(customerUserEmail);
				if (isDeleted) {
					con.commit();
					return true;
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public List<Order> getAllOrder(String userEmailId) {
		
		List<Order> orderList = new ArrayList<Order>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from Orders where userEmailId=?");

			ps.setString(1, userEmailId);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderStatus(rs.getString("orderStatus"));
				order.setBookName(rs.getString("bookName"));
				order.setTotalBill(rs.getDouble("totalBill"));
				order.setUserEmailId(rs.getString("userEmailId"));
				order.setQuantity(rs.getInt("quantity"));
				orderList.add(order);		
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public boolean clearCart(String customerUserEmail) {
		Connection con = ObjectsUtility.getDbConnection();

		try {
			PreparedStatement ps = con.prepareStatement("delete from cart where userEmailId=?");
			

			ps.setString(1, customerUserEmail);

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
	public String checkOrderStatus(int orderId) {

		return null;
	}

	

}
