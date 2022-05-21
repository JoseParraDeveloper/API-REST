package com.products.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.entities.Product;
import com.products.exceptions.ProductNotFoundException;
import com.products.repository.IProductRepository;
import com.products.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public Product findProductById(Long id) throws ProductNotFoundException {
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Producto No Encontrado con id " + id));
	}

	@Override
	public void deleteProductById(Long id) throws ProductNotFoundException {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional.isPresent()) {
			productRepository.deleteById(id);
		}

	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

}
