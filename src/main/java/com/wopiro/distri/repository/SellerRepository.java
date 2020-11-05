package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

}