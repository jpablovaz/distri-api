package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.Zone;

public interface ZoneService {

	public List<Zone> findAll();
	
	public Zone findById(Integer id);
	
	public Zone save(Zone zone);
	
	public void deleteById(Integer id);

}
