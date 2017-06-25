package com.yourstories.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yourstories.model.Post;

public interface PostRepositoryDB extends MongoRepository<Post, String> {

}
