package com.challenge.ms.hex_accreditations.adapter.out.model.persistence;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accreditations")
public class MongoAccreditationEntity {

	@Id
	private String id;
	private Double amount;
	private Integer sellingPointId;
	private String sellingPointName;
	private LocalDateTime receptionDate;

	public MongoAccreditationEntity() {
	}

	public MongoAccreditationEntity(Double amount, Integer sellingPointId, String sellingPointName,
			LocalDateTime receptionDate) {
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

	public Integer getSellingPointId() {
		return sellingPointId;
	}

	public void setSellingPointId(Integer sellingPointId) {
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
