package com.yourstories.services;

import java.util.List;

import com.yourstories.model.Account;
import com.yourstories.repositories.IAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{

	IAccountRepository accountRepository;
	
	@Override
	public List<Account> getAllAccounts() {
		
		return accountRepository.getAllAccounts();
	}

	@Override
	public Account getAccount(String username) {
		
		return accountRepository.getAccount(username);
	}

	@Override
	public Account createAccount(Account account) {
		
		return accountRepository.createAccount(account);
	}

	@Override
	public Account updateAccount(Account account) {
		
		return accountRepository.updateAccount(account);
	}

	@Override
	public void deleteAccount(Account account) {
		accountRepository.deleteAccount(account);
		
	}

	@Override
	public void deleteAccount(String username) {
		
		accountRepository.deleteAccount(username);
	}

	
}
