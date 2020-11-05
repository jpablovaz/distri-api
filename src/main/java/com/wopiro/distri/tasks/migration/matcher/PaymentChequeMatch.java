package com.wopiro.distri.tasks.migration.matcher;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Bank;
import com.wopiro.distri.entity.PaymentCheque;
import com.wopiro.distri.entity.Receipt;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class PaymentChequeMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		System.out.println("## Receipts Cheque");
		for (int i = 0; i < rs.size(); i++) {

			Map<String, Object> row = rs.get(i);
			Long idOld = (Long) row.get(fields.get(0));
			Long idRec = MemoryData.getPayment().get((Long) row.get(fields.get(1)));
			PaymentCheque cheque = new PaymentCheque();
			Receipt receipt = MemoryData.getReceipt().get(idRec);
			cheque.setNumber((String) row.get(fields.get(2)));
			Bank bank = MemoryData.getBanks().get(((Integer) row.get(fields.get(3))));
			cheque.setBank(bank);
			cheque.setLastName((String) row.get(fields.get(4)));
			cheque.setName((String) row.get(fields.get(5)));
			cheque.setExpiration(((Date) row.get(fields.get(6))).toLocalDate());
			cheque.setAmount((Double) row.get(fields.get(7)));

			if (receipt != null) {

				Double total = receipt.getTotal() + cheque.getAmount();
				Double dif = receipt.getTotal_dif() - cheque.getAmount();
				receipt.setTotal(total);
				receipt.setTotal_dif(dif);
				cheque.setReceipt(receipt);

				if (MemoryData.production) {
					RepReference.getReceiptService().save(receipt);
					cheque = RepReference.getPaymentChequeService().save(cheque);
				}

				MemoryData.getCheques().put(idOld, cheque);
			}
		}
	}
}
