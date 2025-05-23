package com.challenge.ms.hex_accreditations.adapter.out.persistence.mongodb;

import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.challenge.ms.hex_accreditations.adapter.out.model.persistence.MongoAccreditationEntity;
import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;
import com.challenge.ms.hex_accreditations.application.port.out.AccreditationRepositoryOuputPort;

import reactor.core.publisher.Mono;

@Component
public class MongoAccreditationRepositoryAdapter implements AccreditationRepositoryOuputPort {

	private final MongoAccreditationRepository mongoAccreditationRepository;

	private static final Logger logger = LoggerFactory.getLogger(MongoAccreditationRepositoryAdapter.class);

	public MongoAccreditationRepositoryAdapter(MongoAccreditationRepository mongoAccreditationRepository) {
		this.mongoAccreditationRepository = mongoAccreditationRepository;
	}

	@Override
	public Mono<Accreditation> findByAccreditationId(Integer accreditationId) {
		return mongoAccreditationRepository.findBySellingPointId(accreditationId)
				.sort(Comparator.comparing(MongoAccreditationEntity::getReceptionDate).reversed()).next()
				.map(AccreditationMongoMapper::fromDbtoDomainModel);
	}

	@Override
	public Mono<Accreditation> save(Accreditation accreditation) {
		logger.info("save");
		return mongoAccreditationRepository.save(AccreditationMongoMapper.fromDomainToDbModel(accreditation))
				.map(AccreditationMongoMapper::fromDbtoDomainModel);
	}
}
