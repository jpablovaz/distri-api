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

import com.wopiro.distri.entity.Driver;
import com.wopiro.distri.service.DriverService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/driver")
public class DriverRestController {

	private DriverService driverService;

	@Autowired
	public DriverRestController(DriverService driverService) {
		this.driverService = driverService;
		RepReference.setDriverService(driverService);
	}

	@GetMapping("/drivers")
	public List<Driver> findAll() {
		return driverService.findAll();
	}

	@GetMapping("/drivers/{id}")
	public Driver getDriver(@PathVariable Integer id) {
		Driver driver = driverService.findById(id);
		if (driver == null) {
			throw new RuntimeException("Driver id not found - " + id);
		}
		return driver;
	}

	@PostMapping("/drivers")
	public Driver addDriver(@RequestBody Driver driver) {
		driver.setId(0);
		return driverService.save(driver);
	}

	@PutMapping("/drivers")
	public Driver updateDriver(@RequestBody Driver driver) {		
		return driverService.save(driver);
	}

	@DeleteMapping("/drivers/{id}")
	public String deleteDriver(@PathVariable Integer id) {
		Driver tempDriver = driverService.findById(id);
		if (tempDriver == null) {
			throw new RuntimeException("Driver id not found - " + id);
		}
		driverService.deleteById(id);
		return "Deleted driver id - " + id;
	}
}
