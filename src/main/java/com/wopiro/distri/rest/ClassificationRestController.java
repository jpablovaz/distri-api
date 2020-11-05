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

import com.wopiro.distri.entity.Classification;
import com.wopiro.distri.service.ClassificationService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/classification")
public class ClassificationRestController {

	private ClassificationService classificationService;

	@Autowired
	public ClassificationRestController(ClassificationService classificationService) {
		this.classificationService = classificationService;
		RepReference.setClassificationService(classificationService);
	}

	@GetMapping("/classifications")
	public List<Classification> findAll() {
		return classificationService.findAll();
	}

	@GetMapping("/classifications/{id}")
	public Classification getClassification(@PathVariable int id) {
		Classification classification = classificationService.findById(id);
		if (classification == null) {
			throw new RuntimeException("Classification id not found - " + id);
		}
		return classification;
	}

	@PostMapping("/classifications")
	public Classification addClassification(@RequestBody Classification classification) {
		classification.setId(0);
		return classificationService.save(classification);
	}

	@PutMapping("/classifications")
	public Classification updateClassification(@RequestBody Classification classification) {		
		return classificationService.save(classification);
	}

	@DeleteMapping("/classifications/{id}")
	public String deleteClassification(@PathVariable int id) {
		Classification tempClassification = classificationService.findById(id);
		if (tempClassification == null) {
			throw new RuntimeException("Classification id not found - " + id);
		}
		classificationService.deleteById(id);
		return "Deleted classification id - " + id;
	}
}
