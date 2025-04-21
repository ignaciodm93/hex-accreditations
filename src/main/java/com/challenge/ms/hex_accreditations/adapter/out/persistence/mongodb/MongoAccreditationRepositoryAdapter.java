package com.challenge.ms.hex_accreditations.adapter.out.persistence.mongodb;

import org.springframework.stereotype.Component;

import com.challenge.ms.hex_accreditations.adapter.out.model.persistence.MongoAccreditationEntity;
import com.challenge.ms.hex_accreditations.adapter.out.persistence.mongodb.repository.MongoAccreditationRepository;
import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;
import com.challenge.ms.hex_accreditations.application.port.out.AccreditationRepositoryPort;

import reactor.core.publisher.Mono;

@Component
public class MongoAccreditationRepositoryAdapter implements AccreditationRepositoryPort {

	private final MongoAccreditationRepository mongoAccreditationRepository;

	public MongoAccreditationRepositoryAdapter(MongoAccreditationRepository mongoAccreditationRepository) {
		this.mongoAccreditationRepository = mongoAccreditationRepository;
	}

	@Override
	public Mono<Accreditation> findByAccreditationId(Integer accreditationId) {
		// revisar
		return mongoAccreditationRepository.findBySellingPointId(accreditationId).map(this::toDomain);
	}

	@Override
	public Mono<Accreditation> save(Accreditation accreditation) {
		return mongoAccreditationRepository.save(toEntity(accreditation)).map(this::toDomain);
	}

	// pasar a un mapper
	private Accreditation toDomain(MongoAccreditationEntity entity) {
		return new Accreditation(entity.getId(), entity.getAmount(), entity.getSellingPointId(),
				entity.getSellingPointName(), entity.getReceptionDate());
	}

	private MongoAccreditationEntity toEntity(Accreditation accreditation) {
		return new MongoAccreditationEntity(accreditation.getAmount(), accreditation.getSellingPointId(),
				accreditation.getSellingPointName(), accreditation.getReceptionDate());
	}
}
