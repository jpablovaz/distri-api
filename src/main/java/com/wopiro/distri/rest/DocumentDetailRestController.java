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

import com.wopiro.distri.entity.DocumentDetail;
import com.wopiro.distri.service.DocumentDetailService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/documentDetail")
public class DocumentDetailRestController {

	private DocumentDetailService documentDetailService;

	@Autowired
	public DocumentDetailRestController(DocumentDetailService documentDetailService) {
		this.documentDetailService = documentDetailService;
		RepReference.setDocumentDetailService(documentDetailService);
	}

	@GetMapping("/documentDetails")
	public List<DocumentDetail> findAll() {
		return documentDetailService.findAll();
	}

	@GetMapping("/documentDetails/{id}")
	public DocumentDetail getDocumentDetail(@PathVariable Long id) {
		DocumentDetail documentDetail = documentDetailService.findById(id);
		if (documentDetail == null) {
			throw new RuntimeException("DocumentDetail id not found - " + id);
		}
		return documentDetail;
	}

	@PostMapping("/documentDetails")
	public DocumentDetail addDocumentDetail(@RequestBody DocumentDetail documentDetail) {
		documentDetail.setId(0L);
		return documentDetailService.save(documentDetail);
	}

	@PutMapping("/documentDetails")
	public DocumentDetail updateDocumentDetail(@RequestBody DocumentDetail documentDetail) {
		return documentDetailService.save(documentDetail);
	}

	@DeleteMapping("/documentDetails/{id}")
	public String deleteDocumentDetail(@PathVariable Long id) {
		DocumentDetail tempDocumentDetail = documentDetailService.findById(id);
		if (tempDocumentDetail == null) {
			throw new RuntimeException("DocumentDetail id not found - " + id);
		}
		documentDetailService.deleteById(id);
		return "Deleted documentDetail id - " + id;
	}
}
