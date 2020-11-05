package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.PaymentOther;
import com.wopiro.distri.entity.Receipt;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class PaymentOtherMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		System.out.println("## Payments Other");
		for (int i = 0; i < rs.size(); i++) {

			Map<String, Object> row = rs.get(i);
			Long idOld = (Long) row.get(fields.get(0));
			Long idRec = MemoryData.getPayment().get((Long) row.get(fields.get(1)));
			PaymentOther other = new PaymentOther();
			Receipt receipt = MemoryData.getReceipt().get(idRec);
			other.setDescription((String) row.get(fields.get(2)));
			other.setObservation((String) row.get(fields.get(3)));
			other.setAmount((Double) row.get(fields.get(4)));

			if (receipt != null) {

				Double total = receipt.getTotal() + other.getAmount();
				Double dif = receipt.getTotal_dif() - other.getAmount();
				receipt.setTotal(total);
				receipt.setTotal_dif(dif);
				other.setReceipt(receipt);

				if (MemoryData.production) {
					RepReference.getReceiptService().save(receipt);
					other = RepReference.getPaymentOtherService().save(other);
				}

				MemoryData.getOthers().put(idOld, other);
			}

		}
	}
}
