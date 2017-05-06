package com.supinfo.supcrowdfunder.dao;

import java.util.List;

import com.supinfo.supcrowdfunder.entity.Category;

public interface CategoryDao {
	
	Category addCategory(Category category);
	
	Category getCategoryById(Long id);
	
	Category getCategoryByName(String categoryName);
	
	List<Category> getAllCategories();

	void removeCategory(Long categoryId);
	
	void removeCategory(Category category);
	
	void updateCategory(Category category);

}
