package com.products.service;

import java.util.List;

import com.products.entities.Category;
import com.products.exceptions.CategoryNotFoundException;

public interface ICategoryService {

	public Category findCategoryById(Long id) throws CategoryNotFoundException;

	public Category findCategoryByName(String name) throws CategoryNotFoundException;

	public void deleteCategoryById(Long id) throws CategoryNotFoundException;

	public Category saveCategory(Category category);

	public List<Category> getAllCategory();

}
