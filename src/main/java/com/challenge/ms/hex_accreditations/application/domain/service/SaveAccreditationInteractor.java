package com.challenge.ms.hex_accreditations.application.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;
import com.challenge.ms.hex_accreditations.application.port.in.SaveAccreditationInputPort;
import com.challenge.ms.hex_accreditations.application.port.out.AccreditationRepositoryOuputPort;
import com.challenge.ms.hex_accreditations.application.port.out.SellingPointCacheOuputPort;

import reactor.core.publisher.Mono;

@Service
public class SaveAccreditationInteractor implements SaveAccreditationInputPort {

	private final AccreditationRepositoryOuputPort accreditationRepositoryPort;
	private final SellingPointCacheOuputPort sellingPointCachePort;

	public SaveAccreditationInteractor(AccreditationRepositoryOuputPort accreditationRepositoryPort,
			SellingPointCacheOuputPort sellingPointCachePort) {
		this.accreditationRepositoryPort = accreditationRepositoryPort;
		this.sellingPointCachePort = sellingPointCachePort;
	}

	@Override
	public Mono<Accreditation> saveAccreditation(Integer sellingPointId, Double amount) {
		return sellingPointCachePort.findSellingPointById(sellingPointId).flatMap(sellingPoint -> {
			Accreditation accreditation = new Accreditation(null, amount, sellingPoint.getId(), sellingPoint.getName(),
					LocalDateTime.now());
			return accreditationRepositoryPort.save(accreditation);
		}).switchIfEmpty(Mono.empty());
	}
}
