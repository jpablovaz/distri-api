package com.wopiro.distri.tasks.migration.matcher;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Brand;
import com.wopiro.distri.entity.Classification;
import com.wopiro.distri.entity.Product;
import com.wopiro.distri.tasks.migration.Dictionary;
import com.wopiro.distri.tasks.migration.MemoryData;
import com.wopiro.distri.tasks.migration.RepReference;

public class ProductMatch {

	public static void persist(String table, List<Map<String, Object>> rs) {

		List<String> fields = Dictionary.get().get(table);
		Product product;
		Brand brand;
		Classification classification;
		System.out.println("## Product");
		for (int i = 0; i < rs.size(); i++) {
			Map<String, Object> row = rs.get(i);
			Integer idOld = ((Long) row.get(fields.get(0))).intValue();
			product = new Product();
			product.setCode(((Long) row.get(fields.get(1))).intValue());
			brand = MemoryData.getBrands().get(((Long) row.get(fields.get(2))).intValue());
			product.setBrand(brand);
			classification = MemoryData.getClassifications().get(((Long) row.get(fields.get(3))).intValue());
			product.setClassification(classification);
			product.setDescription((String) row.get(fields.get(4)));
			product.setUnitWeight((Double) row.get(fields.get(5)));
			product.setCost((Double) row.get(fields.get(6)));
			product.setList1((Double) row.get(fields.get(7)));
			product.setList2((Double) row.get(fields.get(8)));
			product.setList3((Double) row.get(fields.get(9)));
			product.setList4((Double) row.get(fields.get(10)));
			product.setList5((Double) row.get(fields.get(11)));
			product.setList6((Double) row.get(fields.get(12)));
			product.setList7((Double) row.get(fields.get(13)));
			product.setList8((Double) row.get(fields.get(14)));
			product.setSale((Boolean) row.get(fields.get(15)));
			product.setActive((Boolean) row.get(fields.get(16)));
			if(MemoryData.production) {
				product = RepReference.getProductService().save(product);
			}
			MemoryData.getProducts().put(idOld, product);
		}
	}
}