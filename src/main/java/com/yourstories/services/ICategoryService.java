package com.yourstories.services;

import java.util.List;

import com.yourstories.model.Author;
import com.yourstories.model.Category;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ICategoryService {

	@PreAuthorize("hasAuthority('VIEW_ALL_CATEGORIES')")
	List<Category> getAllCategory();
	@PreAuthorize("hasAuthority('VIEW_CATEGORY')")
	Category getCategory(String id);
	@PreAuthorize("hasAuthority('CREATE_CATEGORY')")
	Category createCategory(Category category);
	@PreAuthorize("hasAuthority('UPDATE_CATEGORY')")
	Category updateCategory(Category category);
	@PreAuthorize("hasAuthority('DELETE_CATEGORY')")
	void deleteCategory(Category category);
	@PreAuthorize("hasAuthority('DELETE_CATEGORY')")
	void deleteCategory(String id);
}
