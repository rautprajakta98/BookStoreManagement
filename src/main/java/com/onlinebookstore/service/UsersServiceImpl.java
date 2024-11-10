package com.onlinebookstore.service;

import java.util.ArrayList;
import java.util.List;

import com.onlinebookstore.dao.UsersDao;
import com.onlinebookstore.model.Users;
import com.onlinebookstore.utility.ObjectsUtility;

public class UsersServiceImpl implements UsersService {

	UsersDao usersDao = ObjectsUtility.getCustomerDao();
	int adminlogin = 0;

	@Override
	public boolean addUser(Users user) {
		boolean isCustomerAdded = usersDao.addUser(user);
		if (isCustomerAdded) {
			return true;
		} else {
			return false;

		}
	}

	@Override
	public boolean addAdmin(Users user) {
		boolean isAdminAdded = usersDao.addAdmin(user);
		if (isAdminAdded) {
			return true;
		} else {
			return false;

		}
	}

	@Override
	public boolean updateUser(Users user) {
		boolean isUserAdded = usersDao.updateUser(user);
		if (isUserAdded) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		boolean isDeleted = usersDao.deleteUser(userId);
		return isDeleted;
	}

	@Override
	public Users loginUser(String email, String password) {
		Users u = usersDao.loginUser(email, password);
		return u;
	}

	@Override
	public Users loginAdmin(String email, String pasword) {
		Users u = usersDao.loginAdmin(email, pasword);
		return u;
	}

	@Override
	public boolean changeUser(String email, String newPassword) {
		boolean isUpdated = usersDao.changeUser(email, newPassword);
		if (isUpdated) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Users> getAllUser() {
		List<Users> usersList = new ArrayList<Users>();
		usersList = usersDao.getAllUser();
		return usersList;
	}

	@Override
	public Users getUserById(int userId) {
		Users u = usersDao.getUserById(userId);
		return u;
	}

	@Override
	public Users getUserByName(String userName) {
		Users u = usersDao.getUserByName(userName);
		return u;
	}

	@Override
	public Users getUserByEmail(String email) {
		Users u = usersDao.getUserByEmail(email);
		return u;
	}

}
