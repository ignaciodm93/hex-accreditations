package com.challenge.ms.hex_accreditations.adapter.out.persistence.mongodb;

import com.challenge.ms.hex_accreditations.adapter.out.model.persistence.MongoAccreditationEntity;
import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;

public class AccreditationMongoMapper {

	public static Accreditation fromDbtoDomainModel(MongoAccreditationEntity dbEntity) {
		return new Accreditation(dbEntity.getId(), dbEntity.getAmount(), dbEntity.getSellingPointId(),
				dbEntity.getSellingPointName(), dbEntity.getReceptionDate());
	}

	public static MongoAccreditationEntity fromDomainToDbModel(Accreditation domainEntity) {
		return new MongoAccreditationEntity(domainEntity.getAmount(), domainEntity.getSellingPointId(),
				domainEntity.getSellingPointName(), domainEntity.getReceptionDate());
	}

}
