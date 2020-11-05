package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Zone;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class ZoneMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		Zone zone;
		System.out.println("## Zone");
		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			Integer idOld = ((Long) row.get(fields.get(0))).intValue();
			zone = new Zone();
			zone.setName((String) row.get(fields.get(1)));
			zone.setActive((Boolean) row.get(fields.get(2)));
			if(MemoryData.production) {
				zone = RepReference.getZoneService().save(zone);
			}
			MemoryData.getZones().put(idOld, zone);
		}
	}

}
