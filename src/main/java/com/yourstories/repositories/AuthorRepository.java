package com.yourstories.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.yourstories.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository implements IAuthorRepsitory{

	@Autowired MongoTemplate mongoTemplate;
	@Autowired AuthorRepositoryDB authorRepositoryDB;
	
	@Override
	public List<Author> getAllAuthors() {
		
		return authorRepositoryDB.findAll();
	}

	@Override
	public Author getAuthor(String id) {
		
		return authorRepositoryDB.findOne(id);
	}

	@Override
	public Author createAuthor(Author author) {
		
		return authorRepositoryDB.save(author);
	}

	@Override
	public Author updateAuthor(Author author) {
		
		return authorRepositoryDB.save(author);
	}

	@Override
	public void deleteAuthor(Author author) {
		authorRepositoryDB.delete(author);
		
	}

	@Override
	public void deleteAuthor(String id) {
		authorRepositoryDB.delete(id);
		
	}

	
}
