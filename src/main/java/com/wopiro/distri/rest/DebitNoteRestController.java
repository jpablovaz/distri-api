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

import com.wopiro.distri.entity.DebitNote;
import com.wopiro.distri.service.DebitNoteService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/debitnote")
public class DebitNoteRestController {

	private DebitNoteService debitNoteService;

	@Autowired
	public DebitNoteRestController(DebitNoteService debitNoteService) {
		this.debitNoteService = debitNoteService;
		RepReference.setDebitNoteService(debitNoteService);
	}

	@GetMapping("/debitnotes")
	public List<DebitNote> findAll() {
		return debitNoteService.findAll();
	}

	@GetMapping("/debitnotes/{id}")
	public DebitNote getDebitNote(@PathVariable long id) {
		DebitNote debitNote = debitNoteService.findById(id);
		if (debitNote == null) {
			throw new RuntimeException("DebitNote id not found - " + id);
		}
		return debitNote;
	}

	@PostMapping("/debitnotes")
	public DebitNote addDebitNote(@RequestBody DebitNote debitNote) {
		debitNote.setId(0L);
		return debitNoteService.save(debitNote);
	}

	@PutMapping("/debitnotes")
	public DebitNote updateDebitNote(@RequestBody DebitNote debitNote) {		
		return debitNoteService.save(debitNote);
	}

	@DeleteMapping("/debitnotes/{id}")
	public String deleteDebitNote(@PathVariable long id) {
		DebitNote tempDebitNote = debitNoteService.findById(id);
		if (tempDebitNote == null) {
			throw new RuntimeException("DebitNote id not found - " + id);
		}
		debitNoteService.deleteById(id);
		return "Deleted debitNote id - " + id;
	}
}
