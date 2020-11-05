package com.wopiro.distri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wopiro.distri.entity.Document;
import com.wopiro.distri.service.DocumentService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/document")
public class DocumentRestController {

	private DocumentService documentService;

	@Autowired
	public DocumentRestController(DocumentService documentService) {
		this.documentService = documentService;
		RepReference.setDocumentService(documentService);
	}

	@GetMapping("/documents")
	public List<Document> findAll() {
		return documentService.findAll();
	}

	@GetMapping("/documents/{id}")
	public Document getDocument(@PathVariable Long id) {
		Document document = documentService.findById(id);
		if (document == null) {
			throw new RuntimeException("Document id not found - " + id);
		}
		return document;
	}

	@PostMapping("/documents")
	public Document addDocument(@RequestBody Document document) {
		document.setId(0L);
		return documentService.save(document);
	}

	@PutMapping("/documents")
	public Document updateDocument(@RequestBody Document document) {		
		return documentService.save(document);
	}

	@DeleteMapping("/documents/{id}")
	public String deleteDocument(@PathVariable Long id) {
		Document tempDocument = documentService.findById(id);
		if (tempDocument == null) {
			throw new RuntimeException("Document id not found - " + id);
		}
		documentService.deleteById(id);
		return "Deleted document id - " + id;
	}
}
