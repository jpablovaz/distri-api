package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Seller;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class SellerMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		Seller seller;
		System.out.println("## Seller");
		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			Integer idOld = ((Long) row.get(fields.get(0))).intValue();
			seller = new Seller();
			seller.setName((String) row.get(fields.get(1)));
			seller.setLastName((String) row.get(fields.get(2)));
			seller.setDocNumber((String) row.get(fields.get(3)));
			seller.setAddress((String) row.get(fields.get(4)));
			seller.setPhone((String) row.get(fields.get(5)));
			seller.setPhone1((String) row.get(fields.get(6)));
			seller.setEmail((String) row.get(fields.get(7)));
			seller.setCom1((Double) row.get(fields.get(8)));
			seller.setCom2((Double) row.get(fields.get(9)));
			seller.setCom3((Double) row.get(fields.get(10)));
			seller.setCom4((Double) row.get(fields.get(11)));
			seller.setCom5((Double) row.get(fields.get(12)));
			seller.setCom6((Double) row.get(fields.get(13)));
			seller.setCom7((Double) row.get(fields.get(14)));
			seller.setCom8((Double) row.get(fields.get(15)));
			seller.setObservation((String) row.get(fields.get(16)));
			seller.setActive((Boolean) row.get(fields.get(17)));
			if(MemoryData.production) {
				seller = RepReference.getSellerService().save(seller);
			}
			MemoryData.getSellers().put(idOld, seller);
		}
	}

}
