package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

}