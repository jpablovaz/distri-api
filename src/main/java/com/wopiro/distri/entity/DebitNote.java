package com.wopiro.distri.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(DocType.DEBIT_NOTE+"")
public class DebitNote extends Document {
	
}
