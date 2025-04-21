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
import com.challenge.ms.hex_accreditations.application.port.in.GetAccreditationUseCase;
import com.challenge.ms.hex_accreditations.application.port.in.SaveAccreditationUseCase;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accreditations")
public class AccreditationController {

	private final GetAccreditationUseCase getAccreditationUseCase;
	private final SaveAccreditationUseCase saveAccreditationUseCase;

	public AccreditationController(GetAccreditationUseCase getAccreditationUseCase,
			SaveAccreditationUseCase saveAccreditationUseCase) {
		this.getAccreditationUseCase = getAccreditationUseCase;
		this.saveAccreditationUseCase = saveAccreditationUseCase;
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<Accreditation>> getAccreditation(@PathVariable Integer id) {
		return getAccreditationUseCase.getAccreditation(id).map(accreditation -> ResponseEntity.ok(accreditation))
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}

	@PostMapping
	public Mono<ResponseEntity<?>> saveAccreditation(@RequestBody SaveAccreditationRequest request) {
		return saveAccreditationUseCase.saveAccreditation(request.getSellingPointId(), request.getAmount())
				.map(accreditation -> ResponseEntity.status(HttpStatus.CREATED).body(accreditation));
	}
}