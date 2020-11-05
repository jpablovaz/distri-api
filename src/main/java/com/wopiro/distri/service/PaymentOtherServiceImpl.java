package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.PaymentOther;
import com.wopiro.distri.repository.PaymentOtherRepository;

@Service
public class PaymentOtherServiceImpl implements PaymentOtherService {

	private PaymentOtherRepository paymentOtherRepository;

	@Autowired
	public PaymentOtherServiceImpl(PaymentOtherRepository paymentOtherRepository) {
		this.paymentOtherRepository = paymentOtherRepository;
	}

	@Override
	public List<PaymentOther> findAll() {
		return paymentOtherRepository.findAll();
	}

	@Override
	public PaymentOther findById(Integer id) {
		Optional<PaymentOther> result = paymentOtherRepository.findById(id);

		PaymentOther paymentOther = null;

		if (result.isPresent()) {
			paymentOther = result.get();
		} else {
			throw new RuntimeException("Did not find PaymentOther id - " + id);
		}
		return paymentOther;
	}

	@Override
	public PaymentOther save(PaymentOther paymentOther) {
		return paymentOtherRepository.save(paymentOther);
	}

	@Override
	public void deleteById(Integer id) {
		paymentOtherRepository.deleteById(id);
	}

}
