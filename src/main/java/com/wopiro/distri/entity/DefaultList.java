package com.wopiro.distri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "default_list")
public class DefaultList {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_list_generator")
	@SequenceGenerator(name="default_list_generator", sequenceName = "default_list_sequence", allocationSize = 1, initialValue = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "percent")
	private Double percent;
	
	@Column(name = "name")
	private String name;

	public DefaultList() {
		
	}

	public DefaultList(Double percent) {
		this.percent = percent;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
