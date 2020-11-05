package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.Supplier;

public interface SupplierService {

	public List<Supplier> findAll();
	
	public Supplier findById(Integer id);
	
	public Supplier save(Supplier supplier);
	
	public void deleteById(Integer id);

}
