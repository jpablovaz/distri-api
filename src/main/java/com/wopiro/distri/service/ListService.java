package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.DefaultList;

public interface ListService {

	public List<DefaultList> findAll();
	
	public DefaultList findById(Integer id);
	
	public DefaultList save(DefaultList defaultList);
	
	public void deleteById(Integer id);

}
