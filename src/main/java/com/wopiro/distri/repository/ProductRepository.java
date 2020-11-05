package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}