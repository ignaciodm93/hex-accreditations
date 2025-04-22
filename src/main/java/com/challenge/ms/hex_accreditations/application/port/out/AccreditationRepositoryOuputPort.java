package com.challenge.ms.hex_accreditations.application.port.out;

import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;

import reactor.core.publisher.Mono;

public interface AccreditationRepositoryOuputPort {

	Mono<Accreditation> findByAccreditationId(Integer accreditationId);

	Mono<Accreditation> save(Accreditation accreditation);

}
