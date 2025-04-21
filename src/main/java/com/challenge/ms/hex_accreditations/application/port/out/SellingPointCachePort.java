package com.challenge.ms.hex_accreditations.application.port.out;

import com.challenge.ms.hex_accreditations.application.domain.model.SellingPoint;

import reactor.core.publisher.Mono;

public interface SellingPointCachePort {

	Mono<SellingPoint> findSellingPointById(Integer sellingPointId);

}
