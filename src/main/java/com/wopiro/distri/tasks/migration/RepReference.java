package com.wopiro.distri.tasks.migration;

import com.wopiro.distri.service.BankService;
import com.wopiro.distri.service.BrandService;
import com.wopiro.distri.service.ClassificationService;
import com.wopiro.distri.service.CreditNoteService;
import com.wopiro.distri.service.CustomerService;
import com.wopiro.distri.service.DebitNoteService;
import com.wopiro.distri.service.DocumentDetailService;
import com.wopiro.distri.service.DocumentService;
import com.wopiro.distri.service.DriverService;
import com.wopiro.distri.service.ListService;
import com.wopiro.distri.service.OrderService;
import com.wopiro.distri.service.PaymentChequeService;
import com.wopiro.distri.service.PaymentOtherService;
import com.wopiro.distri.service.ProductService;
import com.wopiro.distri.service.ReceiptService;
import com.wopiro.distri.service.SaleAccountService;
import com.wopiro.distri.service.SaleCashService;
import com.wopiro.distri.service.SellerService;
import com.wopiro.distri.service.SupplierService;
import com.wopiro.distri.service.UserService;
import com.wopiro.distri.service.ZoneService;

public class RepReference {

	static BankService bankService;
	static ClassificationService classificationService;
	static ZoneService zoneService;
	static BrandService brandService;
	static ListService listService;
	static ProductService productService;
	static SupplierService supplierService;
	static DriverService driverService;
	static SellerService sellerService;
	static CustomerService customerService;
	static DocumentService documentService;
	static SaleCashService saleCashService;
	static SaleAccountService saleAccountService;
	static CreditNoteService creditNoteService;
	static DebitNoteService debitNoteService;
	static OrderService orderService;
	static ReceiptService receiptService;
	static DocumentDetailService documentDetailService;
	static PaymentChequeService paymentChequeService;
	static PaymentOtherService paymentOtherService;
	static UserService userService;

	static private int count = 0;
	static private int fields = 0;

	public static void setLength(int length) {
		fields = length - 2;
	}

	static private void check() {
		count++;
		if (count == fields) {
			Migration.migrate();
		}
	}

	public static BankService getBankService() {
		return bankService;
	}

	public static void setBankService(BankService bankService) {
		if (RepReference.bankService == null) {
			RepReference.bankService = bankService;
			check();
		}
	}

	public static ClassificationService getClassificationService() {
		return classificationService;
	}

	public static void setClassificationService(ClassificationService classificationService) {
		if (RepReference.classificationService == null) {
			RepReference.classificationService = classificationService;
			check();
		}
	}

	public static ZoneService getZoneService() {
		return zoneService;
	}

	public static void setZoneService(ZoneService zoneService) {
		if (RepReference.zoneService == null) {
			RepReference.zoneService = zoneService;
			check();
		}
	}

	public static BrandService getBrandService() {
		return brandService;
	}

	public static void setBrandService(BrandService brandService) {
		if (RepReference.brandService == null) {
			RepReference.brandService = brandService;
			check();
		}
	}

	public static ListService getListService() {
		return listService;
	}

	public static void setListService(ListService listService) {
		if (RepReference.listService == null) {
			RepReference.listService = listService;
			check();
		}
	}

	public static ProductService getProductService() {
		return productService;
	}

	public static void setProductService(ProductService productService) {
		if (RepReference.productService == null) {
			RepReference.productService = productService;
			check();
		}
	}

	public static SupplierService getSupplierService() {
		return supplierService;
	}

	public static void setSupplierService(SupplierService supplierService) {
		if (RepReference.supplierService == null) {
			RepReference.supplierService = supplierService;
			check();
		}
	}

	public static DriverService getDriverService() {
		return driverService;
	}

	public static void setDriverService(DriverService driverService) {
		if (RepReference.driverService == null) {
			RepReference.driverService = driverService;
			check();
		}
	}

	public static SellerService getSellerService() {
		return sellerService;
	}

	public static void setSellerService(SellerService sellerService) {
		if (RepReference.sellerService == null) {
			RepReference.sellerService = sellerService;
			check();
		}
	}

	public static CustomerService getCustomerService() {
		return customerService;
	}

	public static void setCustomerService(CustomerService customerService) {
		if (RepReference.customerService == null) {
			RepReference.customerService = customerService;
			check();
		}
	}

	public static DocumentService getDocumentService() {
		return documentService;
	}

	public static void setDocumentService(DocumentService documentService) {
		if (RepReference.documentService == null) {
			RepReference.documentService = documentService;
			check();
		}
	}

	public static SaleCashService getSaleCashService() {
		return saleCashService;
	}

	public static void setSaleCashService(SaleCashService saleCashService) {
		if (RepReference.saleCashService == null) {
			RepReference.saleCashService = saleCashService;
			check();
		}
	}

	public static SaleAccountService getSaleAccountService() {
		return saleAccountService;
	}

	public static void setSaleAccountService(SaleAccountService saleAccountService) {
		if (RepReference.saleAccountService == null) {
			RepReference.saleAccountService = saleAccountService;
			check();
		}
	}

	public static CreditNoteService getCreditNoteService() {
		return creditNoteService;
	}

	public static void setCreditNoteService(CreditNoteService creditNoteService) {
		if (RepReference.creditNoteService == null) {
			RepReference.creditNoteService = creditNoteService;
			check();
		}
	}

	public static DebitNoteService getDebitNoteService() {
		return debitNoteService;
	}

	public static void setDebitNoteService(DebitNoteService debitNoteService) {
		if (RepReference.debitNoteService == null) {
			RepReference.debitNoteService = debitNoteService;
			check();
		}
	}

	public static OrderService getOrderService() {
		return orderService;
	}

	public static void setOrderService(OrderService orderService) {
		if (RepReference.orderService == null) {
			RepReference.orderService = orderService;
			check();
		}
	}

	public static ReceiptService getReceiptService() {
		return receiptService;
	}

	public static void setReceiptService(ReceiptService receiptService) {
		if (RepReference.receiptService == null) {
			RepReference.receiptService = receiptService;
			check();
		}
	}

	public static DocumentDetailService getDocumentDetailService() {
		return documentDetailService;
	}

	public static void setDocumentDetailService(DocumentDetailService documentDetailService) {
		if (RepReference.documentDetailService == null) {
			RepReference.documentDetailService = documentDetailService;
			check();
		}
	}

	public static PaymentChequeService getPaymentChequeService() {
		return paymentChequeService;
	}

	public static void setPaymentChequeService(PaymentChequeService paymentChequeService) {
		if (RepReference.paymentChequeService == null) {
			RepReference.paymentChequeService = paymentChequeService;
			check();
		}
	}

	public static PaymentOtherService getPaymentOtherService() {
		return paymentOtherService;
	}

	public static void setPaymentOtherService(PaymentOtherService paymentOtherService) {
		if (RepReference.paymentOtherService == null) {
			RepReference.paymentOtherService = paymentOtherService;
			check();
		}
	}

	public static UserService getUserService() {
		return userService;
	}

	public static void setUserService(UserService userService) {
		RepReference.setLength(new RepReference().getClass().getDeclaredFields().length);
		if (RepReference.userService == null) {
			RepReference.userService = userService;
			check();
		}
	}

}
