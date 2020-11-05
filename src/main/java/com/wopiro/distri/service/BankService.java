package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.Bank;

public interface BankService {

	public List<Bank> findAll();
	
	public Bank findById(Integer id);
	
	public Bank save(Bank bank);
	
	public void deleteById(Integer id);

}
