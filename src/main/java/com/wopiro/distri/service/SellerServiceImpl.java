package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Seller;
import com.wopiro.distri.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {

	private SellerRepository sellerRepository;

	@Autowired
	public SellerServiceImpl(SellerRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}

	@Override
	public List<Seller> findAll() {
		return sellerRepository.findAll();
	}

	@Override
	public Seller findById(Integer id) {
		Optional<Seller> result = sellerRepository.findById(id);

		Seller seller = null;

		if (result.isPresent()) {
			seller = result.get();
		} else {
			throw new RuntimeException("Did not find Seller id - " + id);
		}
		return seller;
	}

	@Override
	public Seller save(Seller seller) {
		return sellerRepository.save(seller);
	}

	@Override
	public void deleteById(Integer id) {
		sellerRepository.deleteById(id);
	}

}
