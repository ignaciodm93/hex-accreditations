package com.challenge.ms.hex_accreditations.application.domain.service;

import org.springframework.stereotype.Service;

import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;
import com.challenge.ms.hex_accreditations.application.port.in.GetAccreditationInputPort;
import com.challenge.ms.hex_accreditations.application.port.out.AccreditationRepositoryOuputPort;

import reactor.core.publisher.Mono;

@Service
public class GetAccreditationInteractor implements GetAccreditationInputPort {

	private final AccreditationRepositoryOuputPort accreditationRepositoryPort;

	public GetAccreditationInteractor(AccreditationRepositoryOuputPort accreditationRepositoryPort) {
		this.accreditationRepositoryPort = accreditationRepositoryPort;
	}

	@Override
	public Mono<Accreditation> getAccreditation(Integer accreditationId) {
		return accreditationRepositoryPort.findByAccreditationId(accreditationId);
	}
}
