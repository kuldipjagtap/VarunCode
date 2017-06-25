package com.yourstories.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.yourstories.model.Tag;
import org.springframework.stereotype.Repository;

@Repository
public class TagRepository implements ITagRepository{

	@Autowired MongoTemplate mongoTemplate;
	@Autowired TagRepositoryDB tagRepositoryDB;
	
	@Override
	public List<Tag> getAllTags() {
		
		return tagRepositoryDB.findAll();
	}

	@Override
	public Tag getTag(String id) {
		
		return tagRepositoryDB.findOne(id);
	}

	@Override
	public Tag createTag(Tag tag) {
		
		return tagRepositoryDB.save(tag);
	}

	@Override
	public Tag updateTag(Tag tag) {
		
		return tagRepositoryDB.save(tag);
	}

	@Override
	public void deleteTag(Tag tag) {
		tagRepositoryDB.delete(tag);
		
	}

	@Override
	public void deleteTag(String id) {
		tagRepositoryDB.delete(id);
		
	}

	
}
