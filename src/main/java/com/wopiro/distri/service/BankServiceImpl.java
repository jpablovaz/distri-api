package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Bank;
import com.wopiro.distri.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {

	private BankRepository bankRepository;

	@Autowired
	public BankServiceImpl(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}

	@Override
	public List<Bank> findAll() {
		return bankRepository.findAll();
	}

	@Override
	public Bank findById(Integer id) {
		Optional<Bank> result = bankRepository.findById(id);

		Bank bank = null;

		if (result.isPresent()) {
			bank = result.get();
		} else {
			throw new RuntimeException("Did not find Bank id - " + id);
		}
		return bank;
	}

	@Override
	public Bank save(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public void deleteById(Integer id) {
		bankRepository.deleteById(id);
	}

}
