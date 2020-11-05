package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.DefaultList;
import com.wopiro.distri.repository.DefaultListRepository;

@Service
public class ListServiceImpl implements ListService {

	private DefaultListRepository defaultListRepository;

	@Autowired
	public ListServiceImpl(DefaultListRepository defaultListRepository) {
		this.defaultListRepository = defaultListRepository;
	}

	@Override
	public List<DefaultList> findAll() {
		return defaultListRepository.findAll();
	}

	@Override
	public DefaultList findById(Integer id) {
		Optional<DefaultList> result = defaultListRepository.findById(id);

		DefaultList defaultList = null;

		if (result.isPresent()) {
			defaultList = result.get();
		} else {
			throw new RuntimeException("Did not find DefaultList id - " + id);
		}
		return defaultList;
	}

	@Override
	public DefaultList save(DefaultList defaultList) {
		return defaultListRepository.save(defaultList);
	}

	@Override
	public void deleteById(Integer id) {
		defaultListRepository.deleteById(id);
	}

}
