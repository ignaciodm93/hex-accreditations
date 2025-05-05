package com.challenge.ms.hex_accreditations.adapter.out.persistence.mongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.challenge.ms.hex_accreditations.adapter.out.model.persistence.MongoAccreditationEntity;

import reactor.core.publisher.Flux;

public interface MongoAccreditationRepository extends ReactiveMongoRepository<MongoAccreditationEntity, String> {

	Flux<MongoAccreditationEntity> findBySellingPointId(Integer sellingPointId);
}