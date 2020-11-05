package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.Product;

public interface ProductService {

	public List<Product> findAll();
	
	public Product findById(Integer id);
	
	public Product save(Product product);
	
	public void deleteById(Integer id);

}
