package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.Classification;

public interface ClassificationService {

	public List<Classification> findAll();
	
	public Classification findById(Integer id);
	
	public Classification save(Classification classification);
	
	public void deleteById(Integer id);

}
