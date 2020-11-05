package com.wopiro.distri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wopiro.distri.entity.PaymentOther;
import com.wopiro.distri.service.PaymentOtherService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/paymentother")
public class PaymentOtherRestController {

	private PaymentOtherService paymentOtherService;

	@Autowired
	public PaymentOtherRestController(PaymentOtherService paymentOtherService) {
		this.paymentOtherService = paymentOtherService;
		RepReference.setPaymentOtherService(paymentOtherService);
	}

	@GetMapping("/paymentothers")
	public List<PaymentOther> findAll() {
		return paymentOtherService.findAll();
	}

	@GetMapping("/paymentothers/{id}")
	public PaymentOther getPaymentOther(@PathVariable int id) {
		PaymentOther paymentOther = paymentOtherService.findById(id);
		if (paymentOther == null) {
			throw new RuntimeException("PaymentOther id not found - " + id);
		}
		return paymentOther;
	}

	@PostMapping("/paymentothers")
	public PaymentOther addPaymentOther(@RequestBody PaymentOther paymentOther) {
		paymentOther.setId(0);
		return paymentOtherService.save(paymentOther);
	}

	@PutMapping("/paymentothers")
	public PaymentOther updatePaymentOther(@RequestBody PaymentOther paymentOther) {		
		return paymentOtherService.save(paymentOther);
	}

	@DeleteMapping("/paymentothers/{id}")
	public String deletePaymentOther(@PathVariable int id) {
		PaymentOther tempPaymentOther = paymentOtherService.findById(id);
		if (tempPaymentOther == null) {
			throw new RuntimeException("PaymentOther id not found - " + id);
		}
		paymentOtherService.deleteById(id);
		return "Deleted paymentOther id - " + id;
	}
}
