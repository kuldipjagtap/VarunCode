package com.yourstories.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yourstories.model.Author;

public interface AuthorRepositoryDB extends MongoRepository<Author, String>{

}
