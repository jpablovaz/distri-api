package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Receipt;
import com.wopiro.distri.repository.ReceiptRepository;

@Service
public class ReceiptServiceImpl implements ReceiptService {

	private ReceiptRepository receiptRepository;

	@Autowired
	public ReceiptServiceImpl(ReceiptRepository receiptRepository) {
		this.receiptRepository = receiptRepository;
	}

	@Override
	public List<Receipt> findAll() {
return receiptRepository.findAll();
//		Pageable pageable = PageRequest.of(0, 1);
//		return receiptRepository.listUp(2D, pageable);
	}

	@Override
	public Receipt findById(Long id) {
		Optional<Receipt> result = receiptRepository.findById(id);

		Receipt receipt = null;

		if (result.isPresent()) {
			receipt = result.get();
		} else {
			throw new RuntimeException("Did not find Receipt id - " + id);
		}
		return receipt;
	}

	@Override
	public Receipt save(Receipt receipt) {
		return receiptRepository.save(receipt);
	}

	@Override
	public void deleteById(Long id) {
		receiptRepository.deleteById(id);
	}

}
