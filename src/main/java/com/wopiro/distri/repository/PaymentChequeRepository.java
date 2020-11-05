package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.PaymentCheque;

public interface PaymentChequeRepository extends JpaRepository<PaymentCheque, Integer> {

}