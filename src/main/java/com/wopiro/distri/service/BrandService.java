package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.Brand;

public interface BrandService {

	public List<Brand> findAll();
	
	public Brand findById(Integer id);
	
	public Brand save(Brand brand);
	
	public void deleteById(Integer id);

}
