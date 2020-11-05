package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.SaleAccount;

public interface SaleAccountService {

	public List<SaleAccount> findAll();
	
	public SaleAccount findById(Long id);
	
	public SaleAccount save(SaleAccount saleAccount);
	
	public void deleteById(Long id);

}