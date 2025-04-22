package com.challenge.ms.hex_accreditations.adapter.out.cache.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;

import com.challenge.ms.hex_accreditations.application.domain.model.SellingPoint;
import com.challenge.ms.hex_accreditations.application.port.out.SellingPointCachePort;

import reactor.core.publisher.Mono;

@Component
public class RedisSellingPointCacheAdapter implements SellingPointCachePort {

	private final ReactiveRedisTemplate<String, SellingPoint> redisTemplate;
	private static final Logger logger = LoggerFactory.getLogger(RedisSellingPointCacheAdapter.class);

	public RedisSellingPointCacheAdapter(ReactiveRedisTemplate<String, SellingPoint> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public Mono<SellingPoint> findSellingPointById(Integer sellingPointId) {
		return redisTemplate.opsForList().range("sellingPointsList", 0, -1)
				.filter(sellingPoint -> sellingPoint.getId().equals(sellingPointId)).log("redis-selling-point-filter")
				.next().doOnNext(sellingPoint -> logger.info("sellingpoint encontrado en redis: {}", sellingPoint))
				.doOnError(error -> logger.error("sellingPoint no encontrado en redis:", error));
	}
}
