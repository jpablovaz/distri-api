package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Driver;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class DriverMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		Driver driver;
		System.out.println("## Driver");
		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			Integer idOld = ((Long) row.get(fields.get(0))).intValue();
			driver = new Driver();
			driver.setName((String) row.get(fields.get(1)));
			driver.setLastName((String) row.get(fields.get(2)));
			driver.setDocNumber((String) row.get(fields.get(3)));
			driver.setAddress((String) row.get(fields.get(4)));
			driver.setPhone((String) row.get(fields.get(5)));
			driver.setPhone1((String) row.get(fields.get(6)));
			driver.setEmail((String) row.get(fields.get(7)));
			driver.setCom1((Double) row.get(fields.get(8)));
			driver.setCom2((Double) row.get(fields.get(9)));
			driver.setCom3((Double) row.get(fields.get(10)));
			driver.setCom4((Double) row.get(fields.get(11)));
			driver.setCom5((Double) row.get(fields.get(12)));
			driver.setCom6((Double) row.get(fields.get(13)));
			driver.setCom7((Double) row.get(fields.get(14)));
			driver.setCom8((Double) row.get(fields.get(15)));
			driver.setObservation((String) row.get(fields.get(16)));
			driver.setActive((Boolean) row.get(fields.get(17)));
			if(MemoryData.production) {
				driver = RepReference.getDriverService().save(driver);
			}
			MemoryData.getDrivers().put(idOld, driver);
		}
	}
}