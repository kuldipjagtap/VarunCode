package com.yourstories.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yourstories.model.Tag;

public interface TagRepositoryDB extends MongoRepository<Tag, String> {

}
