package com.yourstories.services;

import java.util.List;

import com.yourstories.model.Author;
import com.yourstories.model.User;

public interface IUserService {

	List<User> getAllUsers();
	User getUser(String id);
	User createUser(User author);
	User updateUser(User author);
	void deleteUser(User author);
	void deleteUser(String id);
}
