package com.challenge.ms.hex_accreditations.adapter.out.cache;

import org.springframework.data.redis.core.ReactiveRedisTemplate;

import com.challenge.ms.hex_accreditations.application.domain.model.SellingPoint;
import com.challenge.ms.hex_accreditations.application.port.out.SellingPointCachePort;

import reactor.core.publisher.Mono;

public class RedisSellingPointCacheAdapter implements SellingPointCachePort {

	private final ReactiveRedisTemplate<String, SellingPoint> redisTemplate;

	public RedisSellingPointCacheAdapter(ReactiveRedisTemplate<String, SellingPoint> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public Mono<SellingPoint> findSellingPointById(Integer sellingPointId) {
		String key = "sellingpoint:" + sellingPointId;
		return redisTemplate.opsForValue().get(key);
	}
}
