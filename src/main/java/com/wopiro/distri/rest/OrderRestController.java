package com.wopiro.distri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wopiro.distri.entity.Order;
import com.wopiro.distri.service.OrderService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	private OrderService orderService;

	@Autowired
	public OrderRestController(OrderService orderService) {
		this.orderService = orderService;
		RepReference.setOrderService(orderService);
	}

	@GetMapping("/orders")
	public List<Order> findAll() {
		return orderService.findAll();
	}

	@GetMapping("/orders/{id}")
	public Order getOrder(@PathVariable Long id) {
		Order order = orderService.findById(id);
		if (order == null) {
			throw new RuntimeException("Order id not found - " + id);
		}
		return order;
	}

	@PostMapping("/orders")
	public Order addOrder(@RequestBody Order order) {
		order.setId(0L);
		return orderService.save(order);
	}

	@PutMapping("/orders")
	public Order updateOrder(@RequestBody Order order) {		
		return orderService.save(order);
	}

	@DeleteMapping("/orders/{id}")
	public String deleteOrder(@PathVariable Long id) {
		Order tempOrder = orderService.findById(id);
		if (tempOrder == null) {
			throw new RuntimeException("Order id not found - " + id);
		}
		orderService.deleteById(id);
		return "Deleted order id - " + id;
	}
}
