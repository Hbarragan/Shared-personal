package com.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.entity.Product;
import com.api.service.IProductService;

@RestController
public class ProductoController {
	
	private IProductService productoService;
	
	public ProductoController(IProductService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping("/product")
	public List<Product> product(){
		return (List<Product>) productoService.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Product productById(@PathVariable Long id) {
		return productoService.findById(id);
	}
	
	@PostMapping("/product")
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product producto) {
		return productoService.save(producto);
		
	}
	
	@PutMapping("/product/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product modifyProduct(@RequestBody Product producto, @PathVariable Long id) {
		Product productoDb = productoService.findById(id);
		
		productoDb.setName(producto.getName());
        productoDb.setPrice(producto.getPrice());
        
        return productoService.save(productoDb);
	}
	
	@DeleteMapping("/product/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Long id) {
		productoService.deleteById(id);
	}
	
	@GetMapping("/product/findByNameOrderByNameAsc/{name}")
	public List<Product> findByNameOrderByNameAsc(@PathVariable String name) {
		return productoService.findByNameOrderByNameAsc(name);
	}

}
