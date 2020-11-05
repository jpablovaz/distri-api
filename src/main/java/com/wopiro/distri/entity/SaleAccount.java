package com.wopiro.distri.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(DocType.SALE_ACCOUNT+"")
public class SaleAccount extends Document {
	
}