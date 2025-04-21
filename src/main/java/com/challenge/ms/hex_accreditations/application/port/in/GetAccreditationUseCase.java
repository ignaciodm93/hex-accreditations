package com.challenge.ms.hex_accreditations.application.port.in;

import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;

import reactor.core.publisher.Mono;

public interface GetAccreditationUseCase {

	Mono<Accreditation> getAccreditation(Integer accreditationId);

}
