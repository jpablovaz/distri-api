package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, Integer> {

}
