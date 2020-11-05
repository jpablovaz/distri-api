package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Customer;
import com.wopiro.distri.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Integer id) {
		Optional<Customer> result = customerRepository.findById(id);

		Customer customer = null;

		if (result.isPresent()) {
			customer = result.get();
		} else {
			throw new RuntimeException("Did not find Customer id - " + id);
		}
		return customer;
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteById(Integer id) {
		customerRepository.deleteById(id);
	}

}
