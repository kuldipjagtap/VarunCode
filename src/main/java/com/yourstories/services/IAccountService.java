package com.yourstories.services;

import java.util.List;

import com.yourstories.model.Account;
import com.yourstories.model.Author;

public interface IAccountService {

	List<Account> getAllAccounts();
	Account getAccount(String id);
	Account createAccount(Account account);
	Account updateAccount(Account account);
	void deleteAccount(Account author);
	void deleteAccount(String id);
}
