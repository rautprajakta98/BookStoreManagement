package com.onlinebookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookstore.model.Users;
import com.onlinebookstore.utility.ObjectsUtility;

public class UsersDaoImpl implements UsersDao {

	Connection con = ObjectsUtility.getDbConnection();

	@Override
	public boolean addUser(Users user) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into Users(userName, userAddress, userEmailId, userContactNo, userPassword, isAdmin) values(?,?,?,?,?,?)");

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserAddress());
			ps.setString(3, user.getUserEmailId());
			ps.setString(4, user.getUserContactNo());
			ps.setString(5, user.getUserPassword());
			ps.setBoolean(6, user.isAdmin());

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
	public boolean addAdmin(Users user) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into Users(userName, userAddress, userEmailId, userContactNo, userPassword, isAdmin) values(?,?,?,?,?,?)");

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserAddress());
			ps.setString(3, user.getUserEmailId());
			ps.setString(4, user.getUserContactNo());
			ps.setString(5, user.getUserPassword());
			ps.setBoolean(6, user.isAdmin());

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
	public boolean updateUser(Users user) {

		try {
			PreparedStatement ps = con.prepareStatement(
					"update Users set userName=?, userAddress=?, userEmailId=?, userContactNo=?, userPassword=?, isAdmin=? where userId=?");

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserAddress());
			ps.setString(3, user.getUserEmailId());
			ps.setString(4, user.getUserContactNo());
			ps.setString(5, user.getUserPassword());
			ps.setBoolean(6, user.isAdmin());
			ps.setInt(7, user.getUserId());

			int x = ps.executeUpdate();

			if (x != 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from Users where userId=?");

			ps.setInt(1, userId);

			int x = ps.executeUpdate();
			if (x != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Users loginUser(String email, String password) {
		Users u = getUserByEmail(email);
		if (email.equalsIgnoreCase(u.getUserEmailId()) && password.equalsIgnoreCase(u.getUserPassword())) {
			return u;
		}
		return null;
	}

	@Override
	public Users loginAdmin(String email, String pasword) {
		Users u = getUserByEmail(email);
		if (email.equalsIgnoreCase(u.getUserEmailId()) && pasword.equalsIgnoreCase(u.getUserPassword())
				&& u.isAdmin() == true) {
			return u;
		}
		return null;
	}

	@Override
	public boolean changeUser(String email, String newPassword) {

		try {
			PreparedStatement ps = con.prepareStatement("update Users set userPassword=? where userEmailId=? ");

			ps.setString(1, newPassword);
			ps.setString(2, email);

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
	public List<Users> getAllUser() {
		List<Users> usersList = new ArrayList<Users>();

		try {
			PreparedStatement ps = con.prepareStatement("Select * from Users");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Users u = new Users();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setUserAddress(rs.getString(3));
				u.setUserEmailId(rs.getString(4));
				u.setUserContactNo(rs.getString(5));
				u.setUserPassword(rs.getString(6));
				u.setAdmin(rs.getBoolean(7));
				usersList.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	@Override
	public Users getUserById(int userId) {

		Users u = new Users();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from Users where userId=?");
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setUserAddress(rs.getString(3));
				u.setUserEmailId(rs.getString(4));
				u.setUserContactNo(rs.getString(5));
				u.setUserPassword(rs.getString(6));
				u.setAdmin(rs.getBoolean(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Users getUserByName(String userName) {
		Users u = new Users();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from Users where userName=?");
			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setUserAddress(rs.getString(3));
				u.setUserEmailId(rs.getString(4));
				u.setUserContactNo(rs.getString(5));
				u.setUserPassword(rs.getString(6));
				u.setAdmin(rs.getBoolean(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public Users getUserByEmail(String userEmail) {

		Users u = new Users();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from Users where userEmailId=?");
			ps.setString(1, userEmail);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setUserAddress(rs.getString(3));
				u.setUserEmailId(rs.getString(4));
				u.setUserContactNo(rs.getString(5));
				u.setUserPassword(rs.getString(6));
				u.setAdmin(rs.getBoolean(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}
