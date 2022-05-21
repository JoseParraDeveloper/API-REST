package com.products.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.products.entities.Category;
import com.products.exceptions.CategoryNotFoundException;
import com.products.service.ICategoryService;

@RestController
@RequestMapping("/api/category/")
public class RestCategoryController {
	@Autowired
	private ICategoryService categoryService;

	@GetMapping(value = "all")
	public ResponseEntity<List<Category>> getCategories() {
		List<Category> listaCategorias = categoryService.getAllCategory();
		return ResponseEntity.ok(listaCategorias);
	}

	@GetMapping(value = "{categoryID}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("categoryID") Long categoryId) {
		try {
			Category category = categoryService.findCategoryById(categoryId);
			return ResponseEntity.ok(category);
		} catch (CategoryNotFoundException exception) {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping
	public ResponseEntity<Category> getCategoryByName(
			@RequestParam(name = "name", required = false) String categoryName) {
		try {
			Category category = categoryService.findCategoryByName(categoryName);
			return ResponseEntity.ok(category);
		} catch (CategoryNotFoundException exception) {
			return ResponseEntity.noContent().build();
		} catch (NullPointerException nullPointerException) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category newCategory = categoryService.saveCategory(category);
		return ResponseEntity.ok(newCategory);

	}

	@DeleteMapping(value = "{categoryID}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("categoryID") Long categoryId) {
		try {
			categoryService.deleteCategoryById(categoryId);
			return ResponseEntity.ok(null);
		} catch (CategoryNotFoundException exception) {
			return ResponseEntity.noContent().build();
		}
	}

	@PutMapping
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		Category updateCategory = categoryService.saveCategory(category);
		return ResponseEntity.ok(updateCategory);

	}

}
