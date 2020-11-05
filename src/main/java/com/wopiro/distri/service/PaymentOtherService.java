package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.PaymentOther;

public interface PaymentOtherService {

	public List<PaymentOther> findAll();
	
	public PaymentOther findById(Integer id);
	
	public PaymentOther save(PaymentOther paymentOther);
	
	public void deleteById(Integer id);

}
