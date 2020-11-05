package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.Seller;

public interface SellerService {

	public List<Seller> findAll();
	
	public Seller findById(Integer id);
	
	public Seller save(Seller seller);
	
	public void deleteById(Integer id);

}
