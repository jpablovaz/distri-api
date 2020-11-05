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

import com.wopiro.distri.entity.Zone;
import com.wopiro.distri.service.ZoneService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/zone")
public class ZoneRestController {

	private ZoneService zoneService;

	@Autowired
	public ZoneRestController(ZoneService zoneService) {
		this.zoneService = zoneService;
		RepReference.setZoneService(zoneService);
	}

	@GetMapping("/zones")
	public List<Zone> findAll() {
		return zoneService.findAll();
	}

	@GetMapping("/zones/{id}")
	public Zone getZone(@PathVariable int id) {
		Zone zone = zoneService.findById(id);
		if (zone == null) {
			throw new RuntimeException("Zone id not found - " + id);
		}
		return zone;
	}

	@PostMapping("/zones")
	public Zone addZone(@RequestBody Zone zone) {
		zone.setId(0);
		return zoneService.save(zone);
	}

	@PutMapping("/zones")
	public Zone updateZone(@RequestBody Zone zone) {		
		return zoneService.save(zone);
	}

	@DeleteMapping("/zones/{id}")
	public String deleteZone(@PathVariable int id) {
		Zone tempZone = zoneService.findById(id);
		if (tempZone == null) {
			throw new RuntimeException("Zone id not found - " + id);
		}
		zoneService.deleteById(id);
		return "Deleted zone id - " + id;
	}
}
