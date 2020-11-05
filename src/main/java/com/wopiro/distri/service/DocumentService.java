package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.Document;

public interface DocumentService {

	public List<Document> findAll();
	
	public Document findById(Long id);
	
	public Document save(Document document);
	
	public void deleteById(Long id);

}
