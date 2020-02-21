package com.bund.north.itop.api.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisConfigBackup {
	@Autowired
	private RedisConnectionFactory connectionFactory;

	@Autowired
	private RedisSerializer fastJson2JsonRedisSerializer;

	@Bean(name = "redisTemplate")
	public RedisTemplate<String, Object> fastJsonRedisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(connectionFactory);
		//redis开启事务
		template.setEnableTransactionSupport(true);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(fastJson2JsonRedisSerializer);
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(fastJson2JsonRedisSerializer);
		template.setDefaultSerializer(new StringRedisSerializer());
		template.afterPropertiesSet();
		return template;
	}
}
