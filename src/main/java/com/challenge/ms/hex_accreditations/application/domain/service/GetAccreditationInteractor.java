package com.challenge.ms.hex_accreditations.application.domain.service;

import org.springframework.stereotype.Service;

import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;
import com.challenge.ms.hex_accreditations.application.port.in.GetAccreditationUseCase;
import com.challenge.ms.hex_accreditations.application.port.out.AccreditationRepositoryPort;

import reactor.core.publisher.Mono;

@Service
public class GetAccreditationInteractor implements GetAccreditationUseCase {

	private final AccreditationRepositoryPort accreditationRepositoryPort;

	public GetAccreditationInteractor(AccreditationRepositoryPort accreditationRepositoryPort) {
		this.accreditationRepositoryPort = accreditationRepositoryPort;
	}

	@Override
	public Mono<Accreditation> getAccreditation(Integer accreditationId) {
		return accreditationRepositoryPort.findByAccreditationId(accreditationId);
	}
}
