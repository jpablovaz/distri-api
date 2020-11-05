package com.wopiro.distri.tasks.migration.matcher;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Customer;
import com.wopiro.distri.entity.DebitNote;
import com.wopiro.distri.entity.DocType;
import com.wopiro.distri.entity.Driver;
import com.wopiro.distri.entity.Seller;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.DocumentOrder;
import com.wopiro.distri.tasks.migration.MemoryData;

public class DebitNoteMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		DebitNote document;
		System.out.println("## DebitNote");

		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			Long idOld = (Long) row.get(fields.get(0));
			document = new DebitNote();
			document.setCode(idOld);
			document.setTotal(Double.valueOf(0));
			document.setTotal_dif(Double.valueOf(0));

			Customer customer = MemoryData.getCustomers().get(((Long) row.get(fields.get(1))).intValue());
			document.setCustomer(customer);
			Seller seller = MemoryData.getSellers().get(((Long) row.get(fields.get(2))).intValue());
			document.setSeller(seller);
			Driver driver = MemoryData.getDrivers().get(((Long) row.get(fields.get(3))).intValue());
			document.setDriver(driver);
			document.setUser(MemoryData.getUser());
			document.setComDriver((Double) row.get(fields.get(5)));
			document.setComSeller((Double) row.get(fields.get(6)));
			document.setDateTime(((Timestamp) row.get(fields.get(7))).toLocalDateTime());
			document.setList((Short) row.get(fields.get(10)));
//			if (MemoryData.production) {
//				document = RepReference.getDebitNoteService().save(document);
//			}
			DocumentOrder order = new DocumentOrder(DocType.DEBIT_NOTE, idOld, document.getDateTime());
			MemoryData.getDocumentsOrder().add(order);
			MemoryData.getDebitNotes().put(idOld, document);
		}
	}

}
