package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.Driver;

public interface DriverService {

	public List<Driver> findAll();
	
	public Driver findById(Integer id);
	
	public Driver save(Driver driver);
	
	public void deleteById(Integer id);

}
