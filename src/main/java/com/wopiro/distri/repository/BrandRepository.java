package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}