package com.yourstories.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yourstories.model.Category;

public interface CategoryRepositoryDB extends MongoRepository<Category, String>{

}
