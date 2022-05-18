package com.products.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.entities.Category;
import com.products.exceptions.CategoryNotFoundException;
import com.products.repository.ICategoryRepository;
import com.products.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public Category findCategoryById(Long id) throws CategoryNotFoundException {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("No existe la Categoría con Id " + id));
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findCategoryByName(String name) throws CategoryNotFoundException {
		return categoryRepository.findByName(name).orElseThrow(
				() -> new CategoryNotFoundException("No existe la Categoría con nombre " + name.toUpperCase()));
	}

	@Override
	public void deleteCategoryById(Long id) throws CategoryNotFoundException {
		this.findCategoryById(id);
		categoryRepository.deleteById(id);

	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

}
