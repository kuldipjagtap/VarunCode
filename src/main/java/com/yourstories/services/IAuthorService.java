package com.yourstories.services;

import java.util.List;

import com.yourstories.model.Author;
import org.springframework.security.access.prepost.PreAuthorize;

public interface IAuthorService {

	@PreAuthorize("hasAuthority('ADMIN')")
	List<Author> getAllAuthors();
	@PreAuthorize("hasAuthority('ADMIN')")
	Author getAuthor(String id);
	@PreAuthorize("hasAuthority('ADMIN')")
	Author createAuthor(Author author);
	@PreAuthorize("hasAuthority('ADMIN')")
	Author updateAuthor(Author author);
	@PreAuthorize("hasAuthority('ADMIN')")
	void deleteAuthor(Author author);
	@PreAuthorize("hasAuthority('ADMIN')")
	void deleteAuthor(String id);
}
