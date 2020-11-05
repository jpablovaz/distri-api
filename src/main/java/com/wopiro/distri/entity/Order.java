package com.wopiro.distri.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(DocType.ORDER+"")
public class Order extends Document {
	
}
