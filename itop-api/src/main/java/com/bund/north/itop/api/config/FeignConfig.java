package com.bund.north.itop.api.config;

import feign.Logger;
import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
	@Value("${service.feign.connectTimeout:6000}")
	private int connectTimeout;

	@Value("${service.feign.readTimeout:6000}")
	private int readTimeout;

	@Bean
	public Request.Options options() {
		return new Request.Options(connectTimeout, readTimeout);
	}

	@Bean
	Logger.Level feignLevle() {
		return Logger.Level.FULL;
	}
}
