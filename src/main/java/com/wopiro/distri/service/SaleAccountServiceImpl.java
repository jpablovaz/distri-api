package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.SaleAccount;
import com.wopiro.distri.repository.SaleAccountRepository;

@Service
public class SaleAccountServiceImpl implements SaleAccountService {

	private SaleAccountRepository saleAccountRepository;

	@Autowired
	public SaleAccountServiceImpl(SaleAccountRepository saleAccountRepository) {
		this.saleAccountRepository = saleAccountRepository;
	}

	@Override
	public List<SaleAccount> findAll() {
		return saleAccountRepository.findAll();
//		Pageable pageable = PageRequest.of(0, 1);
//		return saleAccountRepository.listUp(2D, pageable);
	}

	@Override
	public SaleAccount findById(Long id) {
		Optional<SaleAccount> result = saleAccountRepository.findById(id);

		SaleAccount saleAccount = null;

		if (result.isPresent()) {
			saleAccount = result.get();
		} else {
			throw new RuntimeException("Did not find SaleAccount id - " + id);
		}
		return saleAccount;
	}

	@Override
	public SaleAccount save(SaleAccount saleAccount) {
		return saleAccountRepository.save(saleAccount);
	}

	@Override
	public void deleteById(Long id) {
		saleAccountRepository.deleteById(id);
	}

}
