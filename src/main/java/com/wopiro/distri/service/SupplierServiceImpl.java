package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Supplier;
import com.wopiro.distri.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

	private SupplierRepository supplierRepository;

	@Autowired
	public SupplierServiceImpl(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier findById(Integer id) {
		Optional<Supplier> result = supplierRepository.findById(id);

		Supplier supplier = null;

		if (result.isPresent()) {
			supplier = result.get();
		} else {
			throw new RuntimeException("Did not find Supplier id - " + id);
		}
		return supplier;
	}

	@Override
	public Supplier save(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public void deleteById(Integer id) {
		supplierRepository.deleteById(id);
	}

}
