package com.yourstories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yourstories.model.Author;
import com.yourstories.repositories.IAuthorRepsitory;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements IAuthorService{

	@Autowired IAuthorRepsitory authorRepository;
	
	@Override
	public List<Author> getAllAuthors() {
		
		return authorRepository.getAllAuthors();
	}

	@Override
	public Author getAuthor(String id) {
		
		return authorRepository.getAuthor(id);
	}

	@Override
	public Author createAuthor(Author author) {
		
		return authorRepository.createAuthor(author);
	}

	@Override
	public Author updateAuthor(Author author) {
		
		return authorRepository.updateAuthor(author);
	}

	@Override
	public void deleteAuthor(Author author) {
		
		authorRepository.deleteAuthor(author);
	}

	@Override
	public void deleteAuthor(String id) {
		
		authorRepository.deleteAuthor(id);
	}
	
}
