package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.DefaultList;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class ListMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {
		List<String> fields = Dictionary.get().get(table);
		DefaultList list;
		System.out.println("## List");
		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			list = new DefaultList();
			list.setPercent((Double) row.get(fields.get(1)));
			if(MemoryData.production) {
				RepReference.getListService().save(list);
			}
		}
	}
}
