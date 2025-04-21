package com.challenge.ms.hex_accreditations.adapter.in.model;

public class SaveAccreditationRequest {
	private Integer sellingPointId;

	private Double amount;

	public Integer getSellingPointId() {
		return sellingPointId;
	}

	public void setSellingPointId(Integer sellingPointId) {
		this.sellingPointId = sellingPointId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
