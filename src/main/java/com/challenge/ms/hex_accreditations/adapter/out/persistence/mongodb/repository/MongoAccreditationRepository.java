package com.challenge.ms.hex_accreditations.adapter.out.persistence.mongodb.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.challenge.ms.hex_accreditations.adapter.out.model.persistence.MongoAccreditationEntity;

import reactor.core.publisher.Mono;

public interface MongoAccreditationRepository extends ReactiveMongoRepository<MongoAccreditationEntity, String> {

	Mono<MongoAccreditationEntity> findBySellingPointId(Integer sellingPointId);

}