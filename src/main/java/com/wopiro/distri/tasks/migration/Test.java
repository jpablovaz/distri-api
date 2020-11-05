package com.wopiro.distri.tasks.migration;

import java.time.LocalDateTime;

import com.wopiro.distri.entity.Receipt;

public class Test {

	public static void test() {
		Receipt document = new Receipt();
		document.setTotal(Double.valueOf(0));
		document.setTotal_dif(Double.valueOf(0));
		document.setCode(20L);
		document.setDateTime(LocalDateTime.now());
		document = RepReference.getReceiptService().save(document);
		System.out.println("Saved");

		System.out.println("Saved!!");
	}
}
