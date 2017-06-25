package com.yourstories.repositories;

import java.util.List;

import com.yourstories.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository{

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	
}
