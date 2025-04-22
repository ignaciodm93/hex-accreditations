package com.challenge.ms.hex_accreditations.adapter.out.persistence.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;
import com.challenge.ms.hex_accreditations.application.port.out.AccreditationRepositoryPort;

import reactor.core.publisher.Mono;

@Component
public class MongoAccreditationRepositoryAdapter implements AccreditationRepositoryPort {

	private final MongoAccreditationRepository mongoAccreditationRepository;

	private static final Logger logger = LoggerFactory.getLogger(MongoAccreditationRepositoryAdapter.class);

	public MongoAccreditationRepositoryAdapter(MongoAccreditationRepository mongoAccreditationRepository) {
		this.mongoAccreditationRepository = mongoAccreditationRepository;
	}

	@Override
	public Mono<Accreditation> findByAccreditationId(Integer accreditationId) {
		return mongoAccreditationRepository.findBySellingPointId(accreditationId)
				.map(AccreditationMongoMapper::fromDbtoDomainModel);
	}

	@Override
	public Mono<Accreditation> save(Accreditation accreditation) {
		logger.info("save");
		return mongoAccreditationRepository.save(AccreditationMongoMapper.fromDomainToDbModel(accreditation))
				.map(AccreditationMongoMapper::fromDbtoDomainModel);
	}
}
