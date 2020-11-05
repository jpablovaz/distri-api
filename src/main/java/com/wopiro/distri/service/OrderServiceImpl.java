package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Order;
import com.wopiro.distri.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findById(Long id) {
		Optional<Order> result = orderRepository.findById(id);

		Order order = null;

		if (result.isPresent()) {
			order = result.get();
		} else {
			throw new RuntimeException("Did not find Order id - " + id);
		}
		return order;
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
	}

}
