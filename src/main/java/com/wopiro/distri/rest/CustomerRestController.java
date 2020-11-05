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

import com.wopiro.distri.entity.Customer;
import com.wopiro.distri.service.CustomerService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

	private CustomerService customerService;

	@Autowired
	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
		RepReference.setCustomerService(customerService);
	}

	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Customer customer = customerService.findById(id);
		if (customer == null) {
			throw new RuntimeException("Customer id not found - " + id);
		}
		return customer;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		return customerService.save(customer);
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {		
		return customerService.save(customer);
	}

	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		Customer tempCustomer = customerService.findById(id);
		if (tempCustomer == null) {
			throw new RuntimeException("Customer id not found - " + id);
		}
		customerService.deleteById(id);
		return "Deleted customer id - " + id;
	}
}
