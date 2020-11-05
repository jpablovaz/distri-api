package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.PaymentCheque;

public interface PaymentChequeService {

	public List<PaymentCheque> findAll();
	
	public PaymentCheque findById(Integer id);
	
	public PaymentCheque save(PaymentCheque paymentCheque);
	
	public void deleteById(Integer id);

}
