package com.api.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.api.model.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>, ProductRepositoryCustom {
	
	public List<Product> findByNameOrderByNameAsc (String name);
	
	public List<Product> findByNameAndPriceOrderByNameAsc (String name, String price);
	
	@Query("select p from Product p where p.price > 100")
	public List<Product> findProductHigherThan100();
}
