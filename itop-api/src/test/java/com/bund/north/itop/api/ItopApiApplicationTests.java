package com.bund.north.itop.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class ItopApiApplicationTests {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void testRedis() {
		String value1 = redisTemplate.opsForValue().get("key1");
		log.info(value1);
		redisTemplate.opsForValue().set("key2", "value2", 10, TimeUnit.MINUTES);
		redisTemplate.opsForValue().set("key3", "value3", 10, TimeUnit.MINUTES);
		String value2 = redisTemplate.opsForValue().get("key2");
		String value3 = redisTemplate.opsForValue().get("key3");
		log.info(value2);
		log.info(value3);
	}


}
