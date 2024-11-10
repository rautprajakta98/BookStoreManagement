package com.onlinebookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookstore.model.Cart;
import com.onlinebookstore.utility.ObjectsUtility;

public class CartDaoImpl implements CartDao {

	Connection con = ObjectsUtility.getDbConnection();

	@Override
	public boolean addToCart(Cart cart) {

		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into Cart(bookName,bookPrice, Quantity, bookId, userEmailId) values(?,?,?,?,?)");

			ps.setString(1, cart.getBookName());
			ps.setDouble(2, cart.getBookPrice());
			ps.setInt(4, cart.getBookId());
			ps.setInt(3, cart.getQuantity());
			ps.setString(5, cart.getCustomerEmailId());

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
	public List<Cart> showCart(String cartEmail) {
		List<Cart> cartList = new ArrayList<Cart>();

		try {
			PreparedStatement ps = con.prepareStatement("select * from Cart Where userEmailId=?");

			ps.setString(1, cartEmail);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cart cart = new Cart();
				cart.setCartId(rs.getInt("cartId"));
				cart.setBookId(rs.getInt("bookId"));
				cart.setBookName(rs.getString("bookName"));
				cart.setCustomerEmailId(rs.getString("userEmailId"));
				cart.setBookPrice(rs.getDouble("bookPrice"));
				cart.setQuantity(rs.getInt("Quantity"));
				cartList.add(cart);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public boolean deleteFromCart(int cartId) {

		try {
			PreparedStatement ps = con.prepareStatement("delete from Cart where cartId=?");

			ps.setInt(1, cartId);

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
