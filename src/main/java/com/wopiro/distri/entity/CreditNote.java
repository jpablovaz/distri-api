package com.wopiro.distri.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(DocType.CREDIT_NOTE+"")
public class CreditNote extends Document {
	
}
