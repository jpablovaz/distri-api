package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.CreditNote;

public interface CreditNoteService {

	public List<CreditNote> findAll();
	
	public CreditNote findById(Long id);
	
	public CreditNote save(CreditNote creditNote);
	
	public void deleteById(Long id);

}
