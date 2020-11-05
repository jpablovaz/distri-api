package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.DocumentDetail;
import com.wopiro.distri.repository.DocumentDetailRepository;

@Service
public class DocumentDetailServiceImpl implements DocumentDetailService {

	private DocumentDetailRepository documentDetailRepository;

	@Autowired
	public DocumentDetailServiceImpl(DocumentDetailRepository documentDetailRepository) {
		this.documentDetailRepository = documentDetailRepository;
	}

	@Override
	public List<DocumentDetail> findAll() {
		return documentDetailRepository.findAll();
	}

	@Override
	public DocumentDetail findById(Long id) {
		Optional<DocumentDetail> result = documentDetailRepository.findById(id);

		DocumentDetail documentDetail = null;

		if (result.isPresent()) {
			documentDetail = result.get();
		} else {
			throw new RuntimeException("Did not find DocumentDetail id - " + id);
		}
		return documentDetail;
	}

	@Override
	public DocumentDetail save(DocumentDetail documentDetail) {
		return documentDetailRepository.save(documentDetail);
	}

	@Override
	public void deleteById(Long id) {
		documentDetailRepository.deleteById(id);
	}

}
