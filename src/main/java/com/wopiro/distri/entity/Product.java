package com.wopiro.distri.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@SequenceGenerator(name = "product_generator", sequenceName = "product_sequence", allocationSize = 1, initialValue = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "code")
	private Integer code;

	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classification_id")
	private Classification classification;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<DocumentDetail> documentDetails = new ArrayList<>();

	@Column(name = "unit_weight")
	private Double unitWeight;

	@Column(name = "cost")
	private Double cost;

	@Column(name = "list_1")
	private Double list1;

	@Column(name = "list_2")
	private Double list2;

	@Column(name = "list_3")
	private Double list3;

	@Column(name = "list_4")
	private Double list4;

	@Column(name = "list_5")
	private Double list5;

	@Column(name = "list_6")
	private Double list6;

	@Column(name = "list_7")
	private Double list7;

	@Column(name = "list_8")
	private Double list8;

	@Column(name = "list_9")
	private Double list9;

	@Column(name = "list_10")
	private Double list10;

	@Column(name = "list_11")
	private Double list11;

	@Column(name = "list_12")
	private Double list12;

	@Column(name = "sale")
	private Boolean sale;

	@Column(name = "active")
	private Boolean active;

	public Product() {

	}

	public Product(Integer code, String description, Brand brand, Classification classification, Double unitWeight,
			Double cost, Double list1, Double list2, Double list3, Double list4, Double list5, Double list6,
			Double list7, Double list8, Double list9, Double list10, Double list11, Double list12, Boolean sale) {
		this.code = code;
		this.description = description;
		this.brand = brand;
		this.classification = classification;
		this.unitWeight = unitWeight;
		this.cost = cost;
		this.list1 = list1;
		this.list2 = list2;
		this.list3 = list3;
		this.list4 = list4;
		this.list5 = list5;
		this.list6 = list6;
		this.list7 = list7;
		this.list8 = list8;
		this.list9 = list9;
		this.list10 = list10;
		this.list11 = list11;
		this.list12 = list12;
		this.sale = sale;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

//	public List<DocumentDetail> getDocumentDetails() {
//		return documentDetails;
//	}
//
//	public void setDocumentDetails(List<DocumentDetail> documentDetails) {
//		this.documentDetails = documentDetails;
//	}

	public Double getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(Double unitWeight) {
		this.unitWeight = unitWeight;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getList1() {
		return list1;
	}

	public void setList1(Double list1) {
		this.list1 = list1;
	}

	public Double getList2() {
		return list2;
	}

	public void setList2(Double list2) {
		this.list2 = list2;
	}

	public Double getList3() {
		return list3;
	}

	public void setList3(Double list3) {
		this.list3 = list3;
	}

	public Double getList4() {
		return list4;
	}

	public void setList4(Double list4) {
		this.list4 = list4;
	}

	public Double getList5() {
		return list5;
	}

	public void setList5(Double list5) {
		this.list5 = list5;
	}

	public Double getList6() {
		return list6;
	}

	public void setList6(Double list6) {
		this.list6 = list6;
	}

	public Double getList7() {
		return list7;
	}

	public void setList7(Double list7) {
		this.list7 = list7;
	}

	public Double getList8() {
		return list8;
	}

	public void setList8(Double list8) {
		this.list8 = list8;
	}

	public Double getList9() {
		return list9;
	}

	public void setList9(Double list9) {
		this.list9 = list9;
	}

	public Double getList10() {
		return list10;
	}

	public void setList10(Double list10) {
		this.list10 = list10;
	}

	public Double getList11() {
		return list11;
	}

	public void setList11(Double list11) {
		this.list11 = list11;
	}

	public Double getList12() {
		return list12;
	}

	public void setList12(Double list12) {
		this.list12 = list12;
	}

	public Boolean getSale() {
		return sale;
	}

	public void setSale(Boolean sale) {
		this.sale = sale;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}