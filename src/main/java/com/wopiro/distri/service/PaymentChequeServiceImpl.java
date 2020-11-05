package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.PaymentCheque;
import com.wopiro.distri.repository.PaymentChequeRepository;

@Service
public class PaymentChequeServiceImpl implements PaymentChequeService {

	private PaymentChequeRepository paymentChequeRepository;

	@Autowired
	public PaymentChequeServiceImpl(PaymentChequeRepository paymentChequeRepository) {
		this.paymentChequeRepository = paymentChequeRepository;
	}

	@Override
	public List<PaymentCheque> findAll() {
		return paymentChequeRepository.findAll();
	}

	@Override
	public PaymentCheque findById(Integer id) {
		Optional<PaymentCheque> result = paymentChequeRepository.findById(id);

		PaymentCheque paymentCheque = null;

		if (result.isPresent()) {
			paymentCheque = result.get();
		} else {
			throw new RuntimeException("Did not find PaymentCheque id - " + id);
		}
		return paymentCheque;
	}

	@Override
	public PaymentCheque save(PaymentCheque paymentCheque) {
		return paymentChequeRepository.save(paymentCheque);
	}

	@Override
	public void deleteById(Integer id) {
		paymentChequeRepository.deleteById(id);
	}

}
