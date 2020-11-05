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

import com.wopiro.distri.entity.SaleCash;
import com.wopiro.distri.service.SaleCashService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/salecash")
public class SaleCashRestController {

	private SaleCashService saleCashService;

	@Autowired
	public SaleCashRestController(SaleCashService saleCashService) {
		this.saleCashService = saleCashService;
		RepReference.setSaleCashService(saleCashService);
	}

	@GetMapping("/salecashs")
	public List<SaleCash> findAll() {
		return saleCashService.findAll();
	}

	@GetMapping("/salecashs/{id}")
	public SaleCash getSaleCash(@PathVariable Long id) {
		SaleCash saleCash = saleCashService.findById(id);
		if (saleCash == null) {
			throw new RuntimeException("SaleCash id not found - " + id);
		}
		return saleCash;
	}

	@PostMapping("/salecashs")
	public SaleCash addSaleCash(@RequestBody SaleCash saleCash) {
		saleCash.setId(0L);
		return saleCashService.save(saleCash);
	}

	@PutMapping("/salecashs")
	public SaleCash updateSaleCash(@RequestBody SaleCash saleCash) {		
		return saleCashService.save(saleCash);
	}

	@DeleteMapping("/salecashs/{id}")
	public String deleteSaleCash(@PathVariable Long id) {
		SaleCash tempSaleCash = saleCashService.findById(id);
		if (tempSaleCash == null) {
			throw new RuntimeException("SaleCash id not found - " + id);
		}
		saleCashService.deleteById(id);
		return "Deleted saleCash id - " + id;
	}
}
