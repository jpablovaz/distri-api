package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.SaleCash;
import com.wopiro.distri.repository.SaleCashRepository;

@Service
public class SaleCashServiceImpl implements SaleCashService {

	private SaleCashRepository saleCashRepository;

	@Autowired
	public SaleCashServiceImpl(SaleCashRepository saleCashRepository) {
		this.saleCashRepository = saleCashRepository;
	}

	@Override
	public List<SaleCash> findAll() {
		return saleCashRepository.findAll();
	}

	@Override
	public SaleCash findById(Long id) {
		Optional<SaleCash> result = saleCashRepository.findById(id);

		SaleCash saleCash = null;

		if (result.isPresent()) {
			saleCash = result.get();
		} else {
			throw new RuntimeException("Did not find SaleCash id - " + id);
		}
		return saleCash;
	}

	@Override
	public SaleCash save(SaleCash saleCash) {
		return saleCashRepository.save(saleCash);
	}

	@Override
	public void deleteById(Long id) {
		saleCashRepository.deleteById(id);
	}

}
