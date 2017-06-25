package com.yourstories.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.yourstories.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository implements ICategoryRepository{

	@Autowired MongoTemplate mongoTemplate;
	@Autowired CategoryRepositoryDB categoryRepositoryDB;
	
	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepositoryDB.findAll();
	}

	@Override
	public Category getCategory(String id) {
		
		return categoryRepositoryDB.findOne(id);
	}

	@Override
	public Category createCategory(Category category) {
		
		return categoryRepositoryDB.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return categoryRepositoryDB.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		categoryRepositoryDB.delete(category);
		
	}

	@Override
	public void deleteCategory(String id) {
		categoryRepositoryDB.delete(id);
		
	}

	
}
