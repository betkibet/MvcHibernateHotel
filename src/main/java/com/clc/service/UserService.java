package com.clc.service;

import java.util.List;

import com.clc.model.UserModel;

public interface UserService {
	public int addUser(UserModel userModel);
	public int updateUser(UserModel userModel);
	public List<UserModel> listUsers();
	public UserModel getUserById(int id);
	public int removeUser(int id);
}
