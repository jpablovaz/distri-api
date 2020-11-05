package com.wopiro.distri.tasks.migration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wopiro.distri.entity.Bank;
import com.wopiro.distri.entity.Brand;
import com.wopiro.distri.entity.Classification;
import com.wopiro.distri.entity.CreditNote;
import com.wopiro.distri.entity.Customer;
import com.wopiro.distri.entity.DebitNote;
import com.wopiro.distri.entity.DocumentDetail;
import com.wopiro.distri.entity.Driver;
import com.wopiro.distri.entity.PaymentCheque;
import com.wopiro.distri.entity.PaymentOther;
import com.wopiro.distri.entity.Product;
import com.wopiro.distri.entity.Receipt;
import com.wopiro.distri.entity.SaleAccount;
import com.wopiro.distri.entity.SaleCash;
import com.wopiro.distri.entity.Seller;
import com.wopiro.distri.entity.User;
import com.wopiro.distri.entity.Zone;

public class MemoryData {

	private static Map<Integer, Bank> banks = new HashMap<>();
	private static Map<Integer, Brand> brands = new HashMap<>();
	private static Map<Integer, Classification> classifications = new HashMap<>();
	private static Map<Integer, Zone> zones = new HashMap<>();
	private static Map<Integer, Product> products = new HashMap<>();
	private static Map<Integer, Driver> drivers = new HashMap<>();
	private static Map<Integer, Seller> sellers = new HashMap<>();
	private static Map<Integer, Customer> customers = new HashMap<>();

	private static Map<Long, SaleAccount> salesAccount = new HashMap<>();
	private static Map<Long, SaleCash> salesCash = new HashMap<>();
	private static Map<Long, CreditNote> creditNotes = new HashMap<>();
	private static Map<Long, DebitNote> debitNotes = new HashMap<>();
	private static Map<Long, Receipt> receipt = new HashMap<>();
	private static Map<Long, DocumentDetail> details = new HashMap<>();

	private static Map<Long, Long> payment = new HashMap<>();
	private static Map<Long, PaymentCheque> cheques = new HashMap<>();
	private static Map<Long, PaymentOther> others = new HashMap<>();
	
	private static List<DocumentOrder> documentsOrder = new ArrayList<>();

	private static User user;
	public static boolean production = true;

	public static Map<Integer, Bank> getBanks() {
		return banks;
	}

	public static void setBanks(Map<Integer, Bank> banks) {
		MemoryData.banks = banks;
	}

	public static Map<Integer, Brand> getBrands() {
		return brands;
	}

	public static void setBrands(Map<Integer, Brand> brands) {
		MemoryData.brands = brands;
	}

	public static Map<Integer, Classification> getClassifications() {
		return classifications;
	}

	public static void setClassifications(Map<Integer, Classification> classifications) {
		MemoryData.classifications = classifications;
	}

	public static Map<Integer, Zone> getZones() {
		return zones;
	}

	public static void setZones(Map<Integer, Zone> zones) {
		MemoryData.zones = zones;
	}

	public static Map<Integer, Product> getProducts() {
		return products;
	}

	public static void setProducts(Map<Integer, Product> products) {
		MemoryData.products = products;
	}

	public static Map<Integer, Driver> getDrivers() {
		return drivers;
	}

	public static void setDrivers(Map<Integer, Driver> drivers) {
		MemoryData.drivers = drivers;
	}

	public static Map<Integer, Seller> getSellers() {
		return sellers;
	}

	public static void setSellers(Map<Integer, Seller> sellers) {
		MemoryData.sellers = sellers;
	}

	public static Map<Integer, Customer> getCustomers() {
		return customers;
	}

	public static void setCustomers(Map<Integer, Customer> customers) {
		MemoryData.customers = customers;
	}

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		MemoryData.user = user;
	}

	public static Map<Long, SaleAccount> getSalesAccount() {
		return salesAccount;
	}

	public static void setSalesAccount(Map<Long, SaleAccount> salesAccount) {
		MemoryData.salesAccount = salesAccount;
	}

	public static Map<Long, SaleCash> getSalesCash() {
		return salesCash;
	}

	public static void setSalesCash(Map<Long, SaleCash> salesCash) {
		MemoryData.salesCash = salesCash;
	}

	public static Map<Long, CreditNote> getCreditNotes() {
		return creditNotes;
	}

	public static void setCreditNotes(Map<Long, CreditNote> creditNotes) {
		MemoryData.creditNotes = creditNotes;
	}

	public static Map<Long, DebitNote> getDebitNotes() {
		return debitNotes;
	}

	public static void setDebitNotes(Map<Long, DebitNote> debitNotes) {
		MemoryData.debitNotes = debitNotes;
	}

	public static Map<Long, Receipt> getReceipt() {
		return receipt;
	}

	public static void setReceipt(Map<Long, Receipt> receipt) {
		MemoryData.receipt = receipt;
	}

	public static Map<Long, DocumentDetail> getDetails() {
		return details;
	}

	public static void setDetails(Map<Long, DocumentDetail> details) {
		MemoryData.details = details;
	}

	public static Map<Long, PaymentCheque> getCheques() {
		return cheques;
	}

	public static void setCheques(Map<Long, PaymentCheque> cheques) {
		MemoryData.cheques = cheques;
	}

	public static Map<Long, PaymentOther> getOthers() {
		return others;
	}

	public static void setOthers(Map<Long, PaymentOther> others) {
		MemoryData.others = others;
	}

	public static Map<Long, Long> getPayment() {
		return payment;
	}

	public static void setPayment(Map<Long, Long> payment) {
		MemoryData.payment = payment;
	}

	public static List<DocumentOrder> getDocumentsOrder() {
		return documentsOrder;
	}

	public static void setDocumentsOrder(List<DocumentOrder> documentsOrder) {
		MemoryData.documentsOrder = documentsOrder;
	}

}