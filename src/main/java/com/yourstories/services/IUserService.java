package com.yourstories.services;

import com.yourstories.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface IUserService extends UserDetailsService{

	List<User> getAllUsers();
	User getUser(String id);
	User createUser(User author);
	User updateUser(User author);
	void deleteUser(User author);
	void deleteUser(String id);
	void saveUser(
			@NotNull(message = "{validate.authenticate.saveUser}") @Valid
					User principal,
			String newPassword
	);
}
