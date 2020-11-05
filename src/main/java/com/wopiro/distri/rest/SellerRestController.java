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

import com.wopiro.distri.entity.Seller;
import com.wopiro.distri.service.SellerService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/seller")
public class SellerRestController {

	private SellerService sellerService;

	@Autowired
	public SellerRestController(SellerService sellerService) {
		this.sellerService = sellerService;
		RepReference.setSellerService(sellerService);
	}

	@GetMapping("/sellers")
	public List<Seller> findAll() {
		return sellerService.findAll();
	}

	@GetMapping("/sellers/{id}")
	public Seller getSeller(@PathVariable int id) {
		Seller seller = sellerService.findById(id);
		if (seller == null) {
			throw new RuntimeException("Seller id not found - " + id);
		}
		return seller;
	}

	@PostMapping("/sellers")
	public Seller addSeller(@RequestBody Seller seller) {
		seller.setId(0);
		return sellerService.save(seller);
	}

	@PutMapping("/sellers")
	public Seller updateSeller(@RequestBody Seller seller) {		
		return sellerService.save(seller);
	}

	@DeleteMapping("/sellers/{id}")
	public String deleteSeller(@PathVariable int id) {
		Seller tempSeller = sellerService.findById(id);
		if (tempSeller == null) {
			throw new RuntimeException("Seller id not found - " + id);
		}
		sellerService.deleteById(id);
		return "Deleted seller id - " + id;
	}
}
