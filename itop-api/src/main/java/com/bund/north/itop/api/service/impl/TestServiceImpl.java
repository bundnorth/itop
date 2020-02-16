package com.bund.north.itop.api.service.impl;

import com.bund.north.itop.api.clients.user.UserClient;
import com.bund.north.itop.api.service.TestService;
import com.bund.north.itop.common.entity.CommonResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("testService")
@Slf4j
public class TestServiceImpl implements TestService {

	@Autowired
	private UserClient userClient;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String timeOut(int mills) {
		return userClient.timeOut(mills).getData();
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallbackTest")
	public String hystrix(int mills) {
		String result = userClient.timeOut(mills).getData();
		log.info("after timeout");
		return result;
	}

	public String fallbackTest(int mills) {
		return "熔断器开启:" + mills;
	}

	@Override
	public String say() {
		return (String) restTemplate.getForObject("http://itop-user/test/say", CommonResponse.class).getData();
	}

	@Override
	public String sayHello(String name) {
		return userClient.sayHello(name).getData();
	}


}
