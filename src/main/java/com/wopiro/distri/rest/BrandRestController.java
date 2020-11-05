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

import com.wopiro.distri.entity.Brand;
import com.wopiro.distri.service.BrandService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/brand")
public class BrandRestController {

	private BrandService brandService;

	@Autowired
	public BrandRestController(BrandService brandService) {
		this.brandService = brandService;
		RepReference.setBrandService(brandService);
	}

	@GetMapping("/brands")
	public List<Brand> findAll() {
		return brandService.findAll();
	}

	@GetMapping("/brands/{id}")
	public Brand getBrand(@PathVariable int id) {
		Brand brand = brandService.findById(id);
		if (brand == null) {
			throw new RuntimeException("Brand id not found - " + id);
		}
		return brand;
	}

	@PostMapping("/brands")
	public Brand addBrand(@RequestBody Brand brand) {
		brand.setId(0);
		return brandService.save(brand);
	}

	@PutMapping("/brands")
	public Brand updateBrand(@RequestBody Brand brand) {
		return brandService.save(brand);
	}

	@DeleteMapping("/brands/{id}")
	public String deleteBrand(@PathVariable int id) {
		Brand tempBrand = brandService.findById(id);
		if (tempBrand == null) {
			throw new RuntimeException("Brand id not found - " + id);
		}
		brandService.deleteById(id);
		return "Deleted brand id - " + id;
	}
}
