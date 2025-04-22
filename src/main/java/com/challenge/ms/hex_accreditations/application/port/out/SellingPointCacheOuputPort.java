package com.challenge.ms.hex_accreditations.application.port.out;

import com.challenge.ms.hex_accreditations.application.domain.model.SellingPoint;

import reactor.core.publisher.Mono;

public interface SellingPointCacheOuputPort {

	Mono<SellingPoint> findSellingPointById(Integer sellingPointId);

}
