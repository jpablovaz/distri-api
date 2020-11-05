package com.wopiro.distri.tasks.migration.matcher;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Customer;
import com.wopiro.distri.entity.DocType;
import com.wopiro.distri.entity.Receipt;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.DocumentOrder;
import com.wopiro.distri.tasks.migration.MemoryData;

public class ReceiptMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		Receipt document;
		System.out.println("## Receipt");

		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			Long idOld = (Long) row.get(fields.get(0));
			document = new Receipt();
			document.setTotal(Double.valueOf(0));
			document.setTotal_dif(Double.valueOf(0));
			document.setCode(idOld);
			Customer customer = MemoryData.getCustomers().get(((Long) row.get(fields.get(1))).intValue());
			document.setCustomer(customer);
			document.setUser(MemoryData.getUser());
			document.setDateTime(((Timestamp) row.get(fields.get(2))).toLocalDateTime());
//			if (MemoryData.production) {
//				document = RepReference.getReceiptService().save(document);
//			}
			DocumentOrder order = new DocumentOrder(DocType.RECEIPT, idOld, document.getDateTime());
			MemoryData.getDocumentsOrder().add(order);
			MemoryData.getReceipt().put(idOld, document);
		}
	}
}