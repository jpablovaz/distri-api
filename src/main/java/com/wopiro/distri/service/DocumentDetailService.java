package com.wopiro.distri.service;

import java.util.List;

import com.wopiro.distri.entity.DocumentDetail;

public interface DocumentDetailService {

	public List<DocumentDetail> findAll();

	public DocumentDetail findById(Long id);

	public DocumentDetail save(DocumentDetail documentDetail);

	public void deleteById(Long id);

}
