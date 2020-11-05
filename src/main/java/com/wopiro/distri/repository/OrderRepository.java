package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}