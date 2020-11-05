package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}