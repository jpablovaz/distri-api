package com.wopiro.distri.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "document")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name = "type")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_generator")
	@SequenceGenerator(name = "document_generator", sequenceName = "document_sequence", allocationSize = 1, initialValue = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "code")
	private Long code;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id")
	private Seller seller;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driver_id")
	private Driver driver;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<DocumentDetail> details = new ArrayList<>();

	@Column(name = "com_seller")
	private Double comSeller;

	@Column(name = "com_driver")
	private Double comDriver;

	@Column(name = "date_time")
	private LocalDateTime dateTime;

	@Column(name = "list")
	private Short list;

	// 1 = ok, 2 = modified, 3 = deleted
	@Column(name = "status")
	private Short status;

	@Column(name = "total")
	private Double total;

	@Column(name = "total_dif")
	private Double total_dif;
	
	@Column(name = "debt")
	private Double debt;

//	@Column(name = "type", insertable = false, updatable = false)
//	private Integer type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<DocumentDetail> getDetails() {
		return details;
	}

	public void setDetails(List<DocumentDetail> details) {
		this.details = details;
	}
	
	public void addDetail(DocumentDetail detail) {
		if(details == null) {
			details = new ArrayList<>();
		}
		details.add(detail);
	}

	public Double getComSeller() {
		return comSeller;
	}

	public void setComSeller(Double comSeller) {
		this.comSeller = comSeller;
	}

	public Double getComDriver() {
		return comDriver;
	}

	public void setComDriver(Double comDriver) {
		this.comDriver = comDriver;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Short getList() {
		return list;
	}

	public void setList(Short list) {
		this.list = list;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getTotal_dif() {
		return total_dif;
	}

	public void setTotal_dif(Double total_dif) {
		this.total_dif = total_dif;
	}

	public Double getDebt() {
		return debt;
	}

	public void setDebt(Double debt) {
		this.debt = debt;
	}

//
//	public Integer getType() {
//		return type;
//	}
//
//	public void setType(Integer type) {
//		this.type = type;
//	}
//
//	@Override
//	  public int compareTo(Document document) {
//	    return getDateTime().compareTo(document.getDateTime());
//	  }

}
