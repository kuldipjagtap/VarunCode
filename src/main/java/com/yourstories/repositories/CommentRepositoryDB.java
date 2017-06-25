package com.yourstories.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yourstories.model.Comment;

public interface CommentRepositoryDB extends MongoRepository<Comment, String> {

}
