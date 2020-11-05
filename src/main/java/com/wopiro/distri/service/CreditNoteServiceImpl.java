package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.CreditNote;
import com.wopiro.distri.repository.CreditNoteRepository;

@Service
public class CreditNoteServiceImpl implements CreditNoteService {

	private CreditNoteRepository creditNoteRepository;

	@Autowired
	public CreditNoteServiceImpl(CreditNoteRepository creditNoteRepository) {
		this.creditNoteRepository = creditNoteRepository;
	}

	@Override
	public List<CreditNote> findAll() {
		return creditNoteRepository.findAll();
	}

	@Override
	public CreditNote findById(Long id) {
		Optional<CreditNote> result = creditNoteRepository.findById(id);

		CreditNote creditNote = null;

		if (result.isPresent()) {
			creditNote = result.get();
		} else {
			throw new RuntimeException("Did not find CreditNote id - " + id);
		}
		return creditNote;
	}

	@Override
	public CreditNote save(CreditNote creditNote) {
		return creditNoteRepository.save(creditNote);
	}

	@Override
	public void deleteById(Long id) {
		creditNoteRepository.deleteById(id);
	}

}
