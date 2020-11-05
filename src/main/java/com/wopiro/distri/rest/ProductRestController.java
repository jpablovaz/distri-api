package com.wopiro.distri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wopiro.distri.entity.Product;
import com.wopiro.distri.service.ProductService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	private ProductService productService;

	@Autowired
	public ProductRestController(ProductService productService) {
		this.productService = productService;
		RepReference.setProductService(productService);
	}

	@GetMapping("/products")
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable int id) {
		Product product = productService.findById(id);
		if (product == null) {
			throw new RuntimeException("Product id not found - " + id);
		}
		return product;
	}

	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		product.setId(0);
		return productService.save(product);
	}

	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {		
		return productService.save(product);
	}

	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		Product tempProduct = productService.findById(id);
		if (tempProduct == null) {
			throw new RuntimeException("Product id not found - " + id);
		}
		productService.deleteById(id);
		return "Deleted product id - " + id;
	}
}
