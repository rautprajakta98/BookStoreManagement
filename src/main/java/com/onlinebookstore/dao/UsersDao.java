package com.onlinebookstore.dao;

import java.util.List;

import com.onlinebookstore.model.Users;

public interface UsersDao {

	boolean addUser(Users user);
	boolean addAdmin(Users user);
	boolean updateUser(Users user);
	boolean deleteUser(int userId);
	Users loginUser(String email, String password);
	Users loginAdmin(String email,String pasword);
	boolean changeUser(String email, String newPassword);
	
	List<Users> getAllUser();
	Users getUserById(int userId);
	
	Users getUserByName(String userName);
	Users getUserByEmail(String email);
}
