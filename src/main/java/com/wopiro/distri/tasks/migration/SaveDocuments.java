package com.wopiro.distri.tasks.migration;

import java.time.format.DateTimeFormatter;
import java.util.Collections;

import com.wopiro.distri.entity.CreditNote;
import com.wopiro.distri.entity.DebitNote;
import com.wopiro.distri.entity.DocType;
import com.wopiro.distri.entity.Receipt;
import com.wopiro.distri.entity.SaleAccount;
import com.wopiro.distri.entity.SaleCash;

public class SaveDocuments {

	static public void save() {
		order();
	}

	static private void order() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		System.out.println(MemoryData.getSalesAccount().size());
		System.out.println(MemoryData.getSalesCash().size());
		System.out.println(MemoryData.getCreditNotes().size());
		System.out.println(MemoryData.getDebitNotes().size());
		System.out.println(MemoryData.getReceipt().size());

		System.out.println(MemoryData.getSalesAccount().size() + MemoryData.getSalesCash().size()
				+ MemoryData.getCreditNotes().size() + MemoryData.getDebitNotes().size()
				+ MemoryData.getReceipt().size());

		System.out.println(MemoryData.getDocumentsOrder().size());

		Collections.sort(MemoryData.getDocumentsOrder(), (c1, c2) -> {
			if (c1.getDateTime().isBefore(c2.getDateTime()))
				return -1;
			else
				return 1;
		});
		for (int i = 0; i < MemoryData.getDocumentsOrder().size(); i++) {
			DocumentOrder orderDOC = MemoryData.getDocumentsOrder().get(i);
			System.out.println(orderDOC.getType() + " => " + orderDOC.getDateTime().format(formatter));

			if (MemoryData.production) {
				switch (orderDOC.getType()) {

				case DocType.SALE_ACCOUNT:
					SaleAccount saleAccount = MemoryData.getSalesAccount().get(orderDOC.getIdOld());
					saleAccount = RepReference.getSaleAccountService().save(saleAccount);
					break;
				case DocType.SALE_CASH:
					SaleCash saleCash = MemoryData.getSalesCash().get(orderDOC.getIdOld());
					saleCash = RepReference.getSaleCashService().save(saleCash);
					break;
				case DocType.DEBIT_NOTE:
					DebitNote debitNote = MemoryData.getDebitNotes().get(orderDOC.getIdOld());
					debitNote = RepReference.getDebitNoteService().save(debitNote);

					break;
				case DocType.CREDIT_NOTE:
					CreditNote creditNote = MemoryData.getCreditNotes().get(orderDOC.getIdOld());
					creditNote = RepReference.getCreditNoteService().save(creditNote);
					break;
				case DocType.RECEIPT:
					Receipt receipt = MemoryData.getReceipt().get(orderDOC.getIdOld());
					receipt = RepReference.getReceiptService().save(receipt);
					break;

				default:
					break;
				}
			}
		}
	}

}
