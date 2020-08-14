package com.clc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clc.dao.UserDao;
import com.clc.model.UserModel;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	@Transactional
	public int addUser(UserModel userModel) {
		this.userDao.addUser(userModel);
		return 1;
	}

	@Override
	@Transactional
	public int updateUser(UserModel userModel) {
		this.userDao.updateUser(userModel);
		return 1;
	}

	@Override
	@Transactional
	public List<UserModel> listUsers() {
		return this.userDao.listUsers();
	}
	@Override
	@Transactional
	public UserModel getUserById(int id) {
		return this.userDao.getUserById(id);
	}
	@Override
	@Transactional
	public int removeUser(int id) {
		this.userDao.removeUser(id);
		return 1;
	}
	@Override
	public int loginUser(String username, String password) {
		this.userDao.loginUser(username, password);
		return 1;
	}

}
