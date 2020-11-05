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

import com.wopiro.distri.entity.PaymentCheque;
import com.wopiro.distri.service.PaymentChequeService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/paymentCheque")
public class PaymentChequeRestController {

	private PaymentChequeService paymentChequeService;

	@Autowired
	public PaymentChequeRestController(PaymentChequeService paymentChequeService) {
		this.paymentChequeService = paymentChequeService;
		RepReference.setPaymentChequeService(paymentChequeService);
	}

	@GetMapping("/paymentCheques")
	public List<PaymentCheque> findAll() {
		return paymentChequeService.findAll();
	}

	@GetMapping("/paymentCheques/{id}")
	public PaymentCheque getPaymentCheque(@PathVariable int id) {
		PaymentCheque paymentCheque = paymentChequeService.findById(id);
		if (paymentCheque == null) {
			throw new RuntimeException("PaymentCheque id not found - " + id);
		}
		return paymentCheque;
	}

	@PostMapping("/paymentCheques")
	public PaymentCheque addPaymentCheque(@RequestBody PaymentCheque paymentCheque) {
		paymentCheque.setId(0);
		return paymentChequeService.save(paymentCheque);
	}

	@PutMapping("/paymentCheques")
	public PaymentCheque updatePaymentCheque(@RequestBody PaymentCheque paymentCheque) {		
		return paymentChequeService.save(paymentCheque);
	}

	@DeleteMapping("/paymentCheques/{id}")
	public String deletePaymentCheque(@PathVariable int id) {
		PaymentCheque tempPaymentCheque = paymentChequeService.findById(id);
		if (tempPaymentCheque == null) {
			throw new RuntimeException("PaymentCheque id not found - " + id);
		}
		paymentChequeService.deleteById(id);
		return "Deleted paymentCheque id - " + id;
	}
}
