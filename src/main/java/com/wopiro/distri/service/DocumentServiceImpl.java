package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Document;
import com.wopiro.distri.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

	private DocumentRepository documentRepository;

	@Autowired
	public DocumentServiceImpl(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}

	@Override
	public List<Document> findAll() {
		return documentRepository.findAll();
	}

	@Override
	public Document findById(Long id) {
		Optional<Document> result = documentRepository.findById(id);

		Document document = null;

		if (result.isPresent()) {
			document = result.get();
		} else {
			throw new RuntimeException("Did not find Document id - " + id);
		}
		return document;
	}

	@Override
	public Document save(Document document) {
		return documentRepository.save(document);
	}

	@Override
	public void deleteById(Long id) {
		documentRepository.deleteById(id);
	}

}
