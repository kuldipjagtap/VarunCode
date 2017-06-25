package com.yourstories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yourstories.model.Category;
import com.yourstories.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService{

	@Autowired ICategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepository.getAllCategory();
	}

	@Override
	public Category getCategory(String id) {
		
		return categoryRepository.getCategory(id);
	}

	@Override
	public Category createCategory(Category category) {
		
		return categoryRepository.createCategory(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return categoryRepository.updateCategory(category);
	}

	@Override
	public void deleteCategory(Category category) {
		
		categoryRepository.deleteCategory(category);
	}

	@Override
	public void deleteCategory(String id) {
		
		categoryRepository.deleteCategory(id);
	}

	
}
