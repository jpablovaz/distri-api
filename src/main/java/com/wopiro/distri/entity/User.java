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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_distri")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name = "user_generator", sequenceName = "user_sequence", allocationSize = 1, initialValue = 1)
	@Column(name = "id")
	private Integer id;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Document> documents = new ArrayList<>();

	@Column(name = "name")
	private String name;

	@Column(name = "color")
	private Integer color;

	@Column(name = "image")
	private String image;

	@Column(name = "email")
	private String email;

	@Column(name = "active")
	private Boolean active;

	public User() {

	}

	public User(Integer id, String name, Integer color, String image, String email, Boolean active) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.image = image;
		this.email = email;
		this.active = active;
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

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
//
//	public List<Document> getDocuments() {
//		return documents;
//	}
//
//	public void setDocuments(List<Document> documents) {
//		this.documents = documents;
//	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
