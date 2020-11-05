package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}