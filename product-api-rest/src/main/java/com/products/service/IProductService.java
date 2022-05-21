package com.products.service;

import java.util.List;

import com.products.entities.Product;
import com.products.exceptions.ProductNotFoundException;

public interface IProductService {
	public Product findProductById(Long id) throws ProductNotFoundException;

	public void deleteProductById(Long id) throws ProductNotFoundException;

	public Product saveProduct(Product product);

	public List<Product> getAllProduct();
}
