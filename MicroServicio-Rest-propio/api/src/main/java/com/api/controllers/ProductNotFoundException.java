package com.api.controllers;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5215735711056028778L;

	public ProductNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}
