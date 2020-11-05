package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}