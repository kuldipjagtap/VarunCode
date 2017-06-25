package com.yourstories.repositories;

import java.util.List;

import com.yourstories.model.Account;

public interface IAccountRepository {

	List<Account> getAllAccounts();
	Account getAccount(String id);
	Account createAccount(Account account);
	Account updateAccount(Account account);
	void deleteAccount(Account author);
	void deleteAccount(String id);
}
