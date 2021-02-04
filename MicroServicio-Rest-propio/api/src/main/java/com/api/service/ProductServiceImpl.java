package com.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.controllers.ProductNotFoundException;
import com.api.model.ProductRepository;
import com.api.model.entity.Product;

@Service
public class ProductServiceImpl implements IProductService{


	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
		
	}


	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}


	@Override
	@Transactional (readOnly = true)
	public List<Product> findByNameOrderByNameAsc(String name) {
		return productRepository.findByNameOrderByNameAsc(name);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Product> findByNameAndPriceOrderByNameAsc (String name, String price) {
		return productRepository.findByNameAndPriceOrderByNameAsc(name, price);	
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
}
