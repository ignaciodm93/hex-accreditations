package com.challenge.ms.hex_accreditations.application.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;
import com.challenge.ms.hex_accreditations.application.port.in.SaveAccreditationUseCase;
import com.challenge.ms.hex_accreditations.application.port.out.AccreditationRepositoryPort;
import com.challenge.ms.hex_accreditations.application.port.out.SellingPointCachePort;

import reactor.core.publisher.Mono;

@Service
public class SaveAccreditationInteractor implements SaveAccreditationUseCase {

	private final AccreditationRepositoryPort accreditationRepositoryPort;
	private final SellingPointCachePort sellingPointCachePort;

	public SaveAccreditationInteractor(AccreditationRepositoryPort accreditationRepositoryPort,
			SellingPointCachePort sellingPointCachePort) {
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
