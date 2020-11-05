package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Product;
import com.wopiro.distri.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Integer id) {
		Optional<Product> result = productRepository.findById(id);

		Product product = null;

		if (result.isPresent()) {
			product = result.get();
		} else {
			throw new RuntimeException("Did not find Product id - " + id);
		}
		return product;
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}

}
