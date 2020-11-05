package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Driver;
import com.wopiro.distri.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

	private DriverRepository driverRepository;

	@Autowired
	public DriverServiceImpl(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}

	@Override
	public List<Driver> findAll() {
		return driverRepository.findAll();
	}

	@Override
	public Driver findById(Integer id) {
		Optional<Driver> result = driverRepository.findById(id);

		Driver driver = null;

		if (result.isPresent()) {
			driver = result.get();
		} else {
			throw new RuntimeException("Did not find Driver id - " + id);
		}
		return driver;
	}

	@Override
	public Driver save(Driver driver) {
		return driverRepository.save(driver);
	}

	@Override
	public void deleteById(Integer id) {
		driverRepository.deleteById(id);
	}

}
