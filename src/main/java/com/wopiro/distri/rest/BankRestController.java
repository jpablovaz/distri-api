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

import com.wopiro.distri.entity.Bank;
import com.wopiro.distri.service.BankService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/bank")
public class BankRestController {

	private BankService bankService;

	@Autowired
	public BankRestController(BankService bankService) {
		this.bankService = bankService;
		RepReference.setBankService(bankService);
	}

	@GetMapping("/banks")
	public List<Bank> findAll() {
		return bankService.findAll();
	}

	@GetMapping("/banks/{id}")
	public Bank getBank(@PathVariable int id) {
		Bank bank = bankService.findById(id);
		if (bank == null) {
			throw new RuntimeException("Bank id not found - " + id);
		}
		return bank;
	}

	@PostMapping("/banks")
	public Bank addBank(@RequestBody Bank bank) {
		bank.setId(0);
		return bankService.save(bank);
	}

	@PutMapping("/banks")
	public Bank updateBank(@RequestBody Bank bank) {		
		return bankService.save(bank);
	}

	@DeleteMapping("/banks/{id}")
	public String deleteBank(@PathVariable int id) {
		Bank tempBank = bankService.findById(id);
		if (tempBank == null) {
			throw new RuntimeException("Bank id not found - " + id);
		}
		bankService.deleteById(id);
		return "Deleted bank id - " + id;
	}
}
