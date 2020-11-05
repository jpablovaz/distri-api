package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.SaleCash;

public interface SaleCashService {

	public List<SaleCash> findAll();
	
	public SaleCash findById(Long id);
	
	public SaleCash save(SaleCash saleCash);
	
	public void deleteById(Long id);

}
