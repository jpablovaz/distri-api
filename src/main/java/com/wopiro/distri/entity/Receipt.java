package com.wopiro.distri.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(DocType.RECEIPT + "")
public class Receipt extends Document {

	@Column(name = "cash")
	private Double cash;

	@OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<PaymentCheque> cheques = new ArrayList<>();

	@OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<PaymentOther> others = new ArrayList<>();

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public List<PaymentCheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<PaymentCheque> cheques) {
		this.cheques = cheques;
	}

	public List<PaymentOther> getOthers() {
		return others;
	}

	public void setOthers(List<PaymentOther> others) {
		this.others = others;
	}

}