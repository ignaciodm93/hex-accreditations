package com.challenge.ms.hex_accreditations.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.ms.hex_accreditations.adapter.in.model.SaveAccreditationRequest;
import com.challenge.ms.hex_accreditations.application.domain.model.Accreditation;
import com.challenge.ms.hex_accreditations.application.port.in.GetAccreditationInputPort;
import com.challenge.ms.hex_accreditations.application.port.in.SaveAccreditationInputPort;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accreditations")
public class AccreditationController {

	private static final String GET_ACCREDITATION_ERROR_MESSAGE = "The requested selling point was not found on mongo. Please try another identifier.";
	private static final String SAVE_ACCREDITATION_ERROR_MESSAGE = "The requested selling point was not found on redis cache. PLease update cache and try again.";
	private static final String ERROR_REASON_HEADER = "Error-Reason";

	private final GetAccreditationInputPort getAccreditationUseCase;
	private final SaveAccreditationInputPort saveAccreditationUseCase;

	public AccreditationController(GetAccreditationInputPort getAccreditationUseCase,
			SaveAccreditationInputPort saveAccreditationUseCase) {
		this.getAccreditationUseCase = getAccreditationUseCase;
		this.saveAccreditationUseCase = saveAccreditationUseCase;
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Accreditation>> getAccreditation(@PathVariable Integer id) {
		return getAccreditationUseCase.getAccreditation(id).map(accreditation -> ResponseEntity.ok(accreditation))
				.switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
						.header(ERROR_REASON_HEADER, GET_ACCREDITATION_ERROR_MESSAGE).build()));
	}

	@PostMapping
	public Mono<ResponseEntity<Accreditation>> saveAccreditation(@RequestBody SaveAccreditationRequest request) {
		return saveAccreditationUseCase.saveAccreditation(request.getSellingPointId(), request.getAmount())
				.map(accreditation -> ResponseEntity.status(HttpStatus.CREATED).body(accreditation))
				.switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
						.header(ERROR_REASON_HEADER, SAVE_ACCREDITATION_ERROR_MESSAGE).build()));
	}
}