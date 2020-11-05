package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Bank;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class BankMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		Bank bank;
		System.out.println("## Bank");
		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			Integer idOld = (Integer) row.get(fields.get(0));
			bank = new Bank();
			bank.setName((String) row.get(fields.get(1)));
			bank.setActive((Boolean) row.get(fields.get(2)));
			if(MemoryData.production) {
				bank = RepReference.getBankService().save(bank);				
			}
			MemoryData.getBanks().put(idOld, bank);
		}
	}
}