package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

}
