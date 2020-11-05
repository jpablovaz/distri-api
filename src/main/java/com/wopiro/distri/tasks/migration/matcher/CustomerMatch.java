package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Customer;
import com.wopiro.distri.entity.Seller;
import com.wopiro.distri.entity.Zone;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class CustomerMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		Customer customer;
		System.out.println("## Customer");
		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			Integer idOld = ((Long) row.get(fields.get(0))).intValue();
			customer = new Customer();
			customer.setLastName((String) row.get(fields.get(1)));
			customer.setName((String) row.get(fields.get(2)));
			customer.setBusinessName((String) row.get(fields.get(3)));
			customer.setDocNumber((String) row.get(fields.get(4)));
			customer.setCuit((String) row.get(fields.get(5)));
			customer.setAddress((String) row.get(fields.get(6)));
			customer.setMaximumAllowed(((Double) row.get(fields.get(7))).intValue());
			Seller seller = MemoryData.getSellers().get(((Long) row.get(fields.get(8))).intValue());
			customer.setSeller(seller);
			customer.setPhone((String) row.get(fields.get(9)));
			customer.setPhone1((String) row.get(fields.get(10)));
			customer.setEmail((String) row.get(fields.get(11)));
			customer.setVisitingHour((String) row.get(fields.get(12)));
			Zone zone = MemoryData.getZones().get((Integer) row.get(fields.get(13)));
			customer.setZone(zone);
			customer.setBilling(1);
			customer.setObservation((String) row.get(fields.get(15)));
			customer.setActive((Boolean) row.get(fields.get(16)));
			customer.setList((Short) row.get(fields.get(17)));
			if(MemoryData.production) {
				customer = RepReference.getCustomerService().save(customer);
			}
			MemoryData.getCustomers().put(idOld, customer);
		}
	}
}
