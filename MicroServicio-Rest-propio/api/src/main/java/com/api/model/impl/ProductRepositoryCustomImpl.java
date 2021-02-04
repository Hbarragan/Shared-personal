package com.api.model.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.api.model.ProductRepositoryCustom;
import com.api.model.entity.Product;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Product> findProductCustom() {
		return null;
	}

}
