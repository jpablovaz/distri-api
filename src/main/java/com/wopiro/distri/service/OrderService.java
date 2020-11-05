package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.Order;

public interface OrderService {

	public List<Order> findAll();
	
	public Order findById(Long id);
	
	public Order save(Order order);
	
	public void deleteById(Long id);

}
