package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Document;
import com.wopiro.distri.entity.DocumentDetail;
import com.wopiro.distri.entity.Product;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.Migration;
import com.wopiro.distri.tasks.migration.RepReference;

public class DetailsMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		System.out.println("## Details");

		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			DocumentDetail detail = new DocumentDetail();
			Product product = MemoryData.getProducts().get(((Long) row.get(fields.get(1))).intValue());
			Long idOld = (Long) (row.get(fields.get(0)));
			if (product == null) {
				product = MemoryData.getProducts().get(100);
			}
			detail.setProduct(product);
			detail.setWeight(Migration.roundWeight((Double) row.get(fields.get(2))));
			detail.setUnits(Migration.roundMoney((Double) row.get(fields.get(3))));
			if(detail.getUnits() > 999)
				detail.setUnits(999D);
			detail.setPrice(Migration.roundMoney((Double) row.get(fields.get(4))));
			detail.setCost(Migration.roundMoney((Double) row.get(fields.get(5))));
			Document document = null;
			Long idVenta = (Long) row.get(fields.get(7));
			if (table.equals("detalles")) {
				document = MemoryData.getSalesAccount().get(idVenta);
				if (document == null)
					document = MemoryData.getSalesCash().get(idVenta);
			} else if (table.equals("credito_detalles")) {
				document = MemoryData.getCreditNotes().get(idVenta);
			} else {
				document = MemoryData.getDebitNotes().get(idVenta);
			}

			if (document != null) {

				if (document.getTotal() == null) {
					document.setTotal(Double.valueOf(0));
				}
				
				if(document.getCustomer() != null) {
					
					if (document.getDebt() == null) {
						document.setDebt(Double.valueOf(0));
					}
					Double debt = document.getDebt() + (detail.getPrice() * detail.getWeight());
					debt = Migration.roundMoney(debt);
					
				}
				Double total = document.getTotal() + (detail.getPrice() * detail.getWeight());
				total = Migration.roundMoney(total);
				document.setTotal(total);

				document.addDetail(detail);
				detail.setDocument(document);
				if(MemoryData.production) {
					detail = RepReference.getDocumentDetailService().save(detail);
				}
				MemoryData.getDetails().put(idOld, detail);
			}
		}
	}
}
