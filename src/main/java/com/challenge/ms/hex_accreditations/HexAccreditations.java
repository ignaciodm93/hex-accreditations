package com.challenge.ms.hex_accreditations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HexAccreditations {
	public static void main(String[] args) {
		SpringApplication.run(HexAccreditations.class, args);
	}
}
