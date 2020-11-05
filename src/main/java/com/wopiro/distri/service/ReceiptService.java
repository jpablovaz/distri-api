package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.Receipt;

public interface ReceiptService {

	public List<Receipt> findAll();
	
	public Receipt findById(Long id);
	
	public Receipt save(Receipt receipt);
	
	public void deleteById(Long id);

}
