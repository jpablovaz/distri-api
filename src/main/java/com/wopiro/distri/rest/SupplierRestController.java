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

import com.wopiro.distri.entity.Supplier;
import com.wopiro.distri.service.SupplierService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/supplier")
public class SupplierRestController {

	private SupplierService supplierService;

	@Autowired
	public SupplierRestController(SupplierService supplierService) {
		this.supplierService = supplierService;
		RepReference.setSupplierService(supplierService);
	}

	@GetMapping("/suppliers")
	public List<Supplier> findAll() {
		return supplierService.findAll();
	}

	@GetMapping("/suppliers/{id}")
	public Supplier getSupplier(@PathVariable int id) {
		Supplier supplier = supplierService.findById(id);
		if (supplier == null) {
			throw new RuntimeException("Supplier id not found - " + id);
		}
		return supplier;
	}

	@PostMapping("/suppliers")
	public Supplier addSupplier(@RequestBody Supplier supplier) {
		supplier.setId(0);
		return supplierService.save(supplier);
	}

	@PutMapping("/suppliers")
	public Supplier updateSupplier(@RequestBody Supplier supplier) {		
		return supplierService.save(supplier);
	}

	@DeleteMapping("/suppliers/{id}")
	public String deleteSupplier(@PathVariable int id) {
		Supplier tempSupplier = supplierService.findById(id);
		if (tempSupplier == null) {
			throw new RuntimeException("Supplier id not found - " + id);
		}
		supplierService.deleteById(id);
		return "Deleted supplier id - " + id;
	}
}
