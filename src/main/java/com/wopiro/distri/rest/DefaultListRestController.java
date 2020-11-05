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

import com.wopiro.distri.entity.DefaultList;
import com.wopiro.distri.service.ListService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/list")
public class DefaultListRestController {

	private ListService defaultListService;

	@Autowired
	public DefaultListRestController(ListService defaultListService) {
		this.defaultListService = defaultListService;
		RepReference.setListService(defaultListService);
	}

	@GetMapping("/lists")
	public List<DefaultList> findAll() {
		return defaultListService.findAll();
	}

	@GetMapping("/lists/{id}")
	public DefaultList getDefaultList(@PathVariable int id) {
		DefaultList defaultList = defaultListService.findById(id);
		if (defaultList == null) {
			throw new RuntimeException("DefaultList id not found - " + id);
		}
		return defaultList;
	}

	@PostMapping("/lists")
	public DefaultList addDefaultList(@RequestBody DefaultList defaultList) {
		defaultList.setId(0);
		return defaultListService.save(defaultList);
	}

	@PutMapping("/lists")
	public DefaultList updateDefaultList(@RequestBody DefaultList defaultList) {		
		return defaultListService.save(defaultList);
	}

	@DeleteMapping("/lists/{id}")
	public String deleteDefaultList(@PathVariable int id) {
		DefaultList tempDefaultList = defaultListService.findById(id);
		if (tempDefaultList == null) {
			throw new RuntimeException("DefaultList id not found - " + id);
		}
		defaultListService.deleteById(id);
		return "Deleted defaultList id - " + id;
	}
}
