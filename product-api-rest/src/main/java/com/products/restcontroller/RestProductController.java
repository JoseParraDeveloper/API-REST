package com.products.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.entities.Category;

@RestController
@RequestMapping("category")
public class RestProductController {

	@GetMapping
	public ResponseEntity<Category> getCategory() {
		Category category = new Category();
		category.setId(1L);
		category.setName("FERRETERIA");
		category.setDescription("Herramientas para la construcción.");
		return ResponseEntity.ok(category);
	}

}
