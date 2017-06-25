package com.yourstories.repositories;

import java.util.List;

import com.yourstories.model.Author;

public interface IAuthorRepsitory {

	List<Author> getAllAuthors();
	Author getAuthor(String id);
	Author createAuthor(Author author);
	Author updateAuthor(Author author);
	void deleteAuthor(Author author);
	void deleteAuthor(String id);
	
}
