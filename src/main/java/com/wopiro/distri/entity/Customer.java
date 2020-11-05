package com.wopiro.distri.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
	@SequenceGenerator(name = "customer_generator", sequenceName = "customer_sequence", allocationSize = 1, initialValue = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "business_name")
	private String businessName;

	@Column(name = "doc_number")
	private String docNumber;

	@Column(name = "maximum_allowed")
	private Integer maximumAllowed;
	
	@Column(name = "debt")
	private Double debt;

	@Column(name = "address")
	private String address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id")
	private Seller seller;

	@Column(name = "phone")
	private String phone;

	@Column(name = "phone_1")
	private String phone1;

	@Column(name = "cuit")
	private String cuit;

	@Column(name = "email")
	private String email;

	// Save a sequence of day of the week: 246 Tuesday Thursday & Saturday
	// Se carga en memoria
	@Column(name = "call")
	private Integer call;

	@Column(name = "visiting_hour")
	private String visitingHour;

	@Column(name = "billing")
	private Integer billing;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zone_id")
	private Zone zone;
	
	@Column(name = "observation")
	private String observation;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Document> documents = new ArrayList<>();

	@Column(name = "whatsapp")
	private Boolean whatsApp;
	
	@Column(name = "list")
	private Short list;
	
	@Column(name = "active")
	private Boolean active;

	public Customer() {

	}

	public Customer(String name, String lastName, String businessName, String docNumber, Integer maximumAllowed,
			String address, Seller seller, String phone, String phone1, String cuit, String email, String visitingHour,
			Integer billing, Zone zone, String observation) {
		this.name = name;
		this.lastName = lastName;
		this.businessName = businessName;
		this.docNumber = docNumber;
		this.maximumAllowed = maximumAllowed;
		this.address = address;
		this.seller = seller;
		this.phone = phone;
		this.phone1 = phone1;
		this.cuit = cuit;
		this.email = email;
		this.visitingHour = visitingHour;
		this.zone = zone;
		this.billing = billing;
		this.observation = observation;
		this.active = true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public Integer getMaximumAllowed() {
		return maximumAllowed;
	}

	public void setMaximumAllowed(Integer maximumAllowed) {
		this.maximumAllowed = maximumAllowed;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVisitingHour() {
		return visitingHour;
	}

	public void setVisitingHour(String visitingHour) {
		this.visitingHour = visitingHour;
	}

	public Integer getBilling() {
		return billing;
	}

	public void setBilling(Integer billing) {
		this.billing = billing;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	public Zone getZone() {
		return this.zone;
	}
	
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	public Boolean getWhatsApp() {
		return whatsApp;
	}

	public void setWhatsApp(Boolean whatsApp) {
		this.whatsApp = whatsApp;
	}
	
	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Short getList() {
		return list;
	}

	public void setList(Short list) {
		this.list = list;
	}

	public Double getDebt() {
		return debt;
	}

	public void setDebt(Double debt) {
		this.debt = debt;
	}
	
	
	
	

}