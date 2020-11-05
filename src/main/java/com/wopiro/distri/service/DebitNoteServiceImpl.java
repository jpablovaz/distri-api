package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.DebitNote;
import com.wopiro.distri.repository.DebitNoteRepository;

@Service
public class DebitNoteServiceImpl implements DebitNoteService {

	private DebitNoteRepository debitNoteRepository;

	@Autowired
	public DebitNoteServiceImpl(DebitNoteRepository debitNoteRepository) {
		this.debitNoteRepository = debitNoteRepository;
	}

	@Override
	public List<DebitNote> findAll() {
		return debitNoteRepository.findAll();
	}

	@Override
	public DebitNote findById(Long id) {
		Optional<DebitNote> result = debitNoteRepository.findById(id);

		DebitNote debitNote = null;

		if (result.isPresent()) {
			debitNote = result.get();
		} else {
			throw new RuntimeException("Did not find DebitNote id - " + id);
		}
		return debitNote;
	}

	@Override
	public DebitNote save(DebitNote debitNote) {
		return debitNoteRepository.save(debitNote);
	}

	@Override
	public void deleteById(Long id) {
		debitNoteRepository.deleteById(id);
	}

}
