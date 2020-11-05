package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Classification;
import com.wopiro.distri.repository.ClassificationRepository;

@Service
public class ClassificationServiceImpl implements ClassificationService {

	private ClassificationRepository classificationRepository;

	@Autowired
	public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
		this.classificationRepository = classificationRepository;
	}

	@Override
	public List<Classification> findAll() {
		return classificationRepository.findAll();
	}

	@Override
	public Classification findById(Integer id) {
		Optional<Classification> result = classificationRepository.findById(id);

		Classification classification = null;

		if (result.isPresent()) {
			classification = result.get();
		} else {
			throw new RuntimeException("Did not find Classification id - " + id);
		}
		return classification;
	}

	@Override
	public Classification save(Classification classification) {
		return classificationRepository.save(classification);
	}

	@Override
	public void deleteById(Integer id) {
		classificationRepository.deleteById(id);
	}

}
