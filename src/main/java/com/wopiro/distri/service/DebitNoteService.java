package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.DebitNote;

public interface DebitNoteService {

	public List<DebitNote> findAll();
	
	public DebitNote findById(Long id);
	
	public DebitNote save(DebitNote debitNote);
	
	public void deleteById(Long id);

}
