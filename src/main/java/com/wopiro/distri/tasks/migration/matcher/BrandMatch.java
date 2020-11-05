package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Brand;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class BrandMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		Brand brand;
		System.out.println("## Brand");

		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			Integer idOld = ((Long) row.get(fields.get(0))).intValue();
			brand = new Brand();
			brand.setName((String) row.get(fields.get(1)));
			brand.setActive((Boolean) row.get(fields.get(2)));
			if (MemoryData.production) {
				brand = RepReference.getBrandService().save(brand);
			}
			MemoryData.getBrands().put(idOld, brand);
		}
	}
}