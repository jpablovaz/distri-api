package com.wopiro.distri.tasks.migration;

import java.time.LocalDateTime;

public class DocumentOrder {

	private int type;
	private Long idOld;
	private LocalDateTime dateTime;
	
	public DocumentOrder(int type, Long idOld, LocalDateTime dateTime) {
		super();
		this.type = type;
		this.idOld = idOld;
		this.dateTime = dateTime;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Long getIdOld() {
		return idOld;
	}
	public void setIdOld(Long idOld) {
		this.idOld = idOld;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}
