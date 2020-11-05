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

import com.wopiro.distri.entity.SaleAccount;
import com.wopiro.distri.service.SaleAccountService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/saleaccount")
public class SaleAccountRestController {

	private SaleAccountService saleAccountService;

	@Autowired
	public SaleAccountRestController(SaleAccountService saleAccountService) {
		this.saleAccountService = saleAccountService;
		RepReference.setSaleAccountService(saleAccountService);
	}

	@GetMapping("/saleaccounts")
	public List<SaleAccount> findAll() {
		return saleAccountService.findAll();
	}

	@GetMapping("/saleaccounts/{id}")
	public SaleAccount getSaleAccount(@PathVariable Long id) {
		SaleAccount saleAccount = saleAccountService.findById(id);
		if (saleAccount == null) {
			throw new RuntimeException("SaleAccount id not found - " + id);
		}
		return saleAccount;
	}

	@PostMapping("/saleaccounts")
	public SaleAccount addSaleAccount(@RequestBody SaleAccount saleAccount) {
		saleAccount.setId(0L);
		return saleAccountService.save(saleAccount);
	}

	@PutMapping("/saleaccounts")
	public SaleAccount updateSaleAccount(@RequestBody SaleAccount saleAccount) {		
		return saleAccountService.save(saleAccount);
	}

	@DeleteMapping("/saleaccounts/{id}")
	public String deleteSaleAccount(@PathVariable Long id) {
		SaleAccount tempSaleAccount = saleAccountService.findById(id);
		if (tempSaleAccount == null) {
			throw new RuntimeException("SaleAccount id not found - " + id);
		}
		saleAccountService.deleteById(id);
		return "Deleted saleAccount id - " + id;
	}
}
