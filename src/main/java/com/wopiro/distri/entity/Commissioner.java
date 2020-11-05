package com.wopiro.distri.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "commissioner")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name = "type")
public class Commissioner {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commissioner_generator")
	@SequenceGenerator(name="commissioner_generator", sequenceName = "commissioner_sequence", allocationSize = 1, initialValue = 1)
	@Column(name = "id")
	private Integer id;
		
	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "doc_number")
	private String docNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;

	@Column(name = "phone1")
	private String phone1;

	@Column(name = "email")
	private String email;

	@Column(name = "com_1")
	private Double com1;

	@Column(name = "com_2")
	private Double com2;

	@Column(name = "com_3")
	private Double com3;

	@Column(name = "com_4")
	private Double com4;

	@Column(name = "com_5")
	private Double com5;

	@Column(name = "com_6")
	private Double com6;

	@Column(name = "com_7")
	private Double com7;

	@Column(name = "com_8")
	private Double com8;
	
	@Column(name = "com_9")
	private Double com9;
	
	@Column(name = "com_10")
	private Double com10;
	
	@Column(name = "com_11")
	private Double com11;
	
	@Column(name = "com_12")
	private Double com12;

	@Column(name = "observation")
	private String observation;

	@Column(name = "active")
	private Boolean active;

	public Commissioner() {

	}

	public Commissioner(String name, String lastName, String docNumber, String address, String phone, String phone1,
			String email, Double com1, Double com2, Double com3, Double com4, Double com5, Double com6, Double com7,
			Double com8, String observation) {
		this.name = name;
		this.lastName = lastName;
		this.docNumber = docNumber;
		this.address = address;
		this.phone = phone;
		this.phone1 = phone1;
		this.email = email;
		this.com1 = com1;
		this.com2 = com2;
		this.com3 = com3;
		this.com4 = com4;
		this.com5 = com5;
		this.com6 = com6;
		this.com7 = com7;
		this.com8 = com8;
		this.observation = observation;
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

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
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

	public Double getCom1() {
		return com1;
	}

	public void setCom1(Double com1) {
		this.com1 = com1;
	}

	public Double getCom2() {
		return com2;
	}

	public void setCom2(Double com2) {
		this.com2 = com2;
	}

	public Double getCom3() {
		return com3;
	}

	public void setCom3(Double com3) {
		this.com3 = com3;
	}

	public Double getCom4() {
		return com4;
	}

	public void setCom4(Double com4) {
		this.com4 = com4;
	}

	public Double getCom5() {
		return com5;
	}

	public void setCom5(Double com5) {
		this.com5 = com5;
	}

	public Double getCom6() {
		return com6;
	}

	public void setCom6(Double com6) {
		this.com6 = com6;
	}

	public Double getCom7() {
		return com7;
	}

	public void setCom7(Double com7) {
		this.com7 = com7;
	}

	public Double getCom8() {
		return com8;
	}

	public void setCom8(Double com8) {
		this.com8 = com8;
	}
	
	public Double getCom9() {
		return com9;
	}

	public void setCom9(Double com9) {
		this.com9 = com9;
	}
	
	public Double getCom10() {
		return com10;
	}

	public void setCom10(Double com10) {
		this.com10 = com10;
	}
	
	public Double getCom11() {
		return com11;
	}

	public void setCom11(Double com11) {
		this.com11 = com11;
	}
	
	public Double getCom12() {
		return com12;
	}

	public void setCom12(Double com12) {
		this.com12 = com12;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}