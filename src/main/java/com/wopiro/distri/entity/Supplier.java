package com.wopiro.distri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_generator")
	@SequenceGenerator(name="supplier_generator", sequenceName = "supplier_sequence", allocationSize = 1, initialValue = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "cuit")
	private String cuit;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;

	@Column(name = "phone1")
	private String phone1;

	@Column(name = "email")
	private String email;

	@Column(name = "billing")
	private Short billing;
	
	@Column(name = "term")
	private Short term;
	
	@Column(name = "observation")
	private String observation;

	@Column(name = "active")
	private Boolean active;

	public Supplier() {

	}

	public Supplier(String name, String lastName, String cuit, String address, String phone, String phone1, String email,
			Short billing, Short term, String observation) {
		this.name = name;
		this.lastName = lastName;
		this.cuit = cuit;
		this.address = address;
		this.phone = phone;
		this.phone1 = phone1;
		this.email = email;
		this.billing = billing;
		this.term = term;
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

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getBilling() {
		return billing;
	}

	public void setBilling(Short billing) {
		this.billing = billing;
	}

	public Short getTerm() {
		return term;
	}

	public void setTerm(Short term) {
		this.term = term;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	

}