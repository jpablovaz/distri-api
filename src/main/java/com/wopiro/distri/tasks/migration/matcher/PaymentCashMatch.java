package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Receipt;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.Migration;
import com.wopiro.distri.tasks.migration.RepReference;

public class PaymentCashMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		System.out.println("## Receipts Cash");

		for (int i = 0; i < rs.size(); i++) {

			Map<String, Object> row = rs.get(i);
			Receipt receipt = MemoryData.getReceipt().get((Long) row.get(fields.get(1)));
			if (receipt != null) {
				receipt.setCash(Migration.roundMoney((Double) row.get(fields.get(2))));
				Double total = receipt.getTotal() + receipt.getCash();
				Double dif = receipt.getTotal_dif() - receipt.getCash();
				receipt.setTotal(total);
				receipt.setTotal_dif(dif);
				if (MemoryData.production) {
					RepReference.getReceiptService().save(receipt);
				}
			}
		}
	}
}