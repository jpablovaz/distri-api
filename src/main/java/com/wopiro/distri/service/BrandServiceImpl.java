package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Brand;
import com.wopiro.distri.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

	private BrandRepository brandRepository;

	@Autowired
	public BrandServiceImpl(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	@Override
	public Brand findById(Integer id) {
		Optional<Brand> result = brandRepository.findById(id);

		Brand brand = null;

		if (result.isPresent()) {
			brand = result.get();
		} else {
			throw new RuntimeException("Did not find Brand id - " + id);
		}
		return brand;
	}

	@Override
	public Brand save(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public void deleteById(Integer id) {
		brandRepository.deleteById(id);
	}

}
