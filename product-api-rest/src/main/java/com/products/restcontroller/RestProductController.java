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
import org.springframework.web.bind.annotation.RestController;

import com.products.entities.Product;
import com.products.exceptions.ProductNotFoundException;
import com.products.service.IProductService;

@RestController
@RequestMapping(value = "/api/products/")
public class RestProductController {

	@Autowired
	private IProductService productService;

	@GetMapping(value = "{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable(name = "productId") Long id) {
		try {
			Product product = productService.findProductById(id);
			return ResponseEntity.ok(product);

		} catch (ProductNotFoundException productNotFoundException) {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProduct());
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product newProduct = productService.saveProduct(product);
		return ResponseEntity.ok(newProduct);

	}

	@DeleteMapping(value = "{productID}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productID") Long productId) {
		try {
			productService.deleteProductById(productId);
			return ResponseEntity.ok(null);
		} catch (ProductNotFoundException exception) {
			return ResponseEntity.noContent().build();
		}
	}

	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product updateProduct = productService.saveProduct(product);
		return ResponseEntity.ok(updateProduct);

	}

}
