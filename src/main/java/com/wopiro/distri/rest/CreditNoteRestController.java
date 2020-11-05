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

import com.wopiro.distri.entity.CreditNote;
import com.wopiro.distri.service.CreditNoteService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/creditnote")
public class CreditNoteRestController {

	private CreditNoteService creditNoteService;

	@Autowired
	public CreditNoteRestController(CreditNoteService creditNoteService) {
		this.creditNoteService = creditNoteService;
		RepReference.setCreditNoteService(creditNoteService);
	}

	@GetMapping("/creditnotes")
	public List<CreditNote> findAll() {
		return creditNoteService.findAll();
	}

	@GetMapping("/creditnotes/{id}")
	public CreditNote getCreditNote(@PathVariable long id) {
		CreditNote creditNote = creditNoteService.findById(id);
		if (creditNote == null) {			
			throw new RuntimeException("CreditNote id not found - " + id);
		}
		return creditNote;
	}

	@PostMapping("/creditnotes")
	public CreditNote addCreditNote(@RequestBody CreditNote creditNote) {
		creditNote.setId(0L);
		return creditNoteService.save(creditNote);
	}

	@PutMapping("/creditnotes")
	public CreditNote updateCreditNote(@RequestBody CreditNote creditNote) {		
		return creditNoteService.save(creditNote);
	}

	@DeleteMapping("/creditnotes/{id}")
	public String deleteCreditNote(@PathVariable long id) {
		CreditNote tempCreditNote = creditNoteService.findById(id);
		if (tempCreditNote == null) {
			throw new RuntimeException("CreditNote id not found - " + id);
		}
		creditNoteService.deleteById(id);
		return "Deleted creditNote id - " + id;
	}
}
