package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Supplier;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class SupplierMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {
		List<String> fields = Dictionary.get().get(table);
		Supplier supplier;
		System.out.println("## Supplier");
		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			supplier = new Supplier();
			supplier.setName((String) row.get(fields.get(1)));
			supplier.setAddress((String) row.get(fields.get(2)));
			supplier.setCuit((String) row.get(fields.get(3)));
			supplier.setPhone((String) row.get(fields.get(4)));
			supplier.setPhone1((String) row.get(fields.get(5)));
			supplier.setEmail((String) row.get(fields.get(6)));
			supplier.setTerm(((Long) row.get(fields.get(7))).shortValue());
			supplier.setBilling(((Integer) row.get(fields.get(8))).shortValue());
			supplier.setObservation((String) row.get(fields.get(9)));
			supplier.setActive((Boolean) row.get(fields.get(10)));
			if(MemoryData.production) {
				RepReference.getSupplierService().save(supplier);
			}
		}
	}

}
