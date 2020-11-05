package com.wopiro.distri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wopiro.distri.entity.Zone;
import com.wopiro.distri.repository.ZoneRepository;

@Service
public class ZoneServiceImpl implements ZoneService {

	private ZoneRepository zoneRepository;

	@Autowired
	public ZoneServiceImpl(ZoneRepository zoneRepository) {
		this.zoneRepository = zoneRepository;
	}

	@Override
	public List<Zone> findAll() {
		return zoneRepository.findAll();
	}

	@Override
	public Zone findById(Integer id) {
		Optional<Zone> result = zoneRepository.findById(id);

		Zone zone = null;

		if (result.isPresent()) {
			zone = result.get();
		} else {
			throw new RuntimeException("Did not find Zone id - " + id);
		}
		return zone;
	}

	@Override
	public Zone save(Zone zone) {
		return zoneRepository.save(zone);
	}

	@Override
	public void deleteById(Integer id) {
		zoneRepository.deleteById(id);
	}

}
