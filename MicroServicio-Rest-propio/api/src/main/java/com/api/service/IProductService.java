package com.api.service;

import java.util.List;

import com.api.model.entity.Product;

public interface IProductService {

		public List<Product> findAll();
		public Product findById (Long id);
		public List<Product> findByNameOrderByNameAsc (String name);
		public List<Product> findByNameAndPriceOrderByNameAsc (String name, String price);
		public Product save(Product producto);
		public void deleteById(Long id);
}
