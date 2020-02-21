package com.bund.north.itop.api.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
	@Autowired
	private static StringRedisTemplate stringRedisTemplate;

	@Autowired
	private static RedisTemplate<String, Object> redisTemplate;

	public static void setRedis(String key, Object value, long seconds) {
		if (value instanceof String) {
			stringRedisTemplate.opsForValue().set(key, (String) value, seconds, TimeUnit.SECONDS);
		}
		redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
	}

	public static String getStringRedis(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	public static Object getObjectRedis(String key) {
		return redisTemplate.opsForValue().get(key);
	}

}
