package com.yourstories.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yourstories.model.Comment;

import java.util.List;

public interface CommentRepositoryDB extends MongoRepository<Comment, String> {

    List<Comment> getByPostId(String postId);
}
