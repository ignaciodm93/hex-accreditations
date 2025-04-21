package com.challenge.ms.hex_accreditations.application.domain.model;

import java.time.LocalDateTime;

public class Accreditation {

	private String id;
	private Double amount;
	private int sellingPointId;
	private String sellingPointName;
	private LocalDateTime receptionDate;

	public Accreditation() {
	}

	public Accreditation(String id, Double amount, Integer sellingPointId, String sellingPointName,
			LocalDateTime receptionDate) {
		this.id = id;
		this.amount = amount;
		this.sellingPointId = sellingPointId;
		this.sellingPointName = sellingPointName;
		this.receptionDate = receptionDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getSellingPointId() {
		return sellingPointId;
	}

	public void setSellingPointId(int sellingPointId) {
		this.sellingPointId = sellingPointId;
	}

	public String getSellingPointName() {
		return sellingPointName;
	}

	public void setSellingPointName(String sellingPointName) {
		this.sellingPointName = sellingPointName;
	}

	public LocalDateTime getReceptionDate() {
		return receptionDate;
	}

	public void setReceptionDate(LocalDateTime receptionDate) {
		this.receptionDate = receptionDate;
	}

}
