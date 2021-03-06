package com.bund.north.itop.api.controller;

import com.bund.north.itop.api.service.TestService;
import com.bund.north.itop.common.entity.CommonResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
	@Autowired
	private TestService testService;

	@Autowired
	private StringRedisTemplate redisTemplate;

	@ApiOperation("测试timeout")
	@GetMapping("/timeout")
	public CommonResponse<String> timeout(@RequestParam(name = "mills") int mills) {
		return CommonResponse.success(testService.timeOut(mills));
	}

	@ApiOperation("测试restTemplate url直连")
	@GetMapping("/say")
	public CommonResponse<String> say() {
		return CommonResponse.success(testService.say());
	}

	@ApiOperation("测试feign REST调用")
	@GetMapping("/sayHello")
	public CommonResponse<String> sayHello(@RequestParam(name = "name") String name) {
		return CommonResponse.success(testService.sayHello(name));
	}

	@ApiOperation(value = "测试熔断器")
	@GetMapping("/hystrix/{id}")
	public CommonResponse<String> hystrix(@PathVariable int id) {
		return CommonResponse.success(testService.hystrix(id));
	}

	@GetMapping("/redis/set")
	public CommonResponse<String> setRedis(@RequestParam("key") String key,
										   @RequestParam("value") String value) {
		String redisValue = redisTemplate.opsForValue().get(key);
		log.info("setRedis#getValue is [{}] with key:[{}] ", redisValue, key);
		if (Objects.isNull(redisValue)) {
			redisTemplate.opsForValue().set(key, value, 5, TimeUnit.SECONDS);
			redisValue = value;
			log.info("setRedis#redisValue is NULL with key:[{}],value:[{}] ", key, value);
		}
		return CommonResponse.success(redisValue);
	}

}
