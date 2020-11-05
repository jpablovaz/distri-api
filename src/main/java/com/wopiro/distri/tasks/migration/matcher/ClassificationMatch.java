package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Classification;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class ClassificationMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		Classification classification;
		System.out.println("## Classification");
		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			Integer idOld = ((Long) row.get(fields.get(0))).intValue();
			classification = new Classification();
			classification.setName((String) row.get(fields.get(1)));
			classification.setActive((Boolean) row.get(fields.get(2)));
			if (MemoryData.production) {
				classification = RepReference.getClassificationService().save(classification);
			}
			MemoryData.getClassifications().put(idOld, classification);
		}

	}

}
