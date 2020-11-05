package com.wopiro.distri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wopiro.distri.entity.Receipt;
import com.wopiro.distri.service.ReceiptService;
import com.wopiro.distri.tasks.migration.RepReference;

@RestController
@RequestMapping("/receipt")
public class ReceiptRestController {

	private ReceiptService receiptService;

	@Autowired
	public ReceiptRestController(ReceiptService receiptService) {
		this.receiptService = receiptService;
		RepReference.setReceiptService(receiptService);
	}

	@GetMapping("/receipts")
	public List<Receipt> findAll() {
		return receiptService.findAll();
	}

	@GetMapping("/receipts/{id}")
	public Receipt getReceipt(@PathVariable Long id) {
		Receipt receipt = receiptService.findById(id);
		if (receipt == null) {
			throw new RuntimeException("Receipt id not found - " + id);
		}
		return receipt;
	}

	@PostMapping("/receipts")
	public Receipt addReceipt(@RequestBody Receipt receipt) {
		receipt.setId(0L);
		return receiptService.save(receipt);
	}

	@PutMapping("/receipts")
	public Receipt updateReceipt(@RequestBody Receipt receipt) {		
		return receiptService.save(receipt);
	}

	@DeleteMapping("/receipts/{id}")
	public String deleteReceipt(@PathVariable Long id) {
		Receipt tempReceipt = receiptService.findById(id);
		if (tempReceipt == null) {
			throw new RuntimeException("Receipt id not found - " + id);
		}
		receiptService.deleteById(id);
		return "Deleted receipt id - " + id;
	}
}
