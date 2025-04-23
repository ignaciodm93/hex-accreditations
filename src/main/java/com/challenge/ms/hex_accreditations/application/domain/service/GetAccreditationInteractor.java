package com.challenge.ms.hex_accreditations.application.domain.service;

import org.springframework.stereotype.Service;

import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;
import com.challenge.ms.hex_accreditations.application.port.in.GetAccreditationInputPort;
import com.challenge.ms.hex_accreditations.application.port.out.AccreditationRepositoryOuputPort;

import reactor.core.publisher.Mono;

@Service
public class GetAccreditationInteractor implements GetAccreditationInputPort {

	private final AccreditationRepositoryOuputPort accreditationRepositoryOutputPort;

	public GetAccreditationInteractor(AccreditationRepositoryOuputPort accreditationRepositoryOutputPort) {
		this.accreditationRepositoryOutputPort = accreditationRepositoryOutputPort;
	}

	@Override
	public Mono<Accreditation> getAccreditation(Integer accreditationId) {
		return accreditationRepositoryOutputPort.findByAccreditationId(accreditationId);
	}
}
