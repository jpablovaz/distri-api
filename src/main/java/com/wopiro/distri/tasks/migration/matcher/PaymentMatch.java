package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Receipt;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;

public class PaymentMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		System.out.println("## Payment - Receipt");

		for (int i = 0; i < rs.size(); i++) {

			Map<String, Object> row = rs.get(i);
			Receipt receipt = MemoryData.getReceipt().get((Long) row.get(fields.get(1)));
			if (receipt != null) {				
				MemoryData.getPayment().put((Long) row.get(fields.get(0)), (Long) row.get(fields.get(1)));
			}
		}
	}
}