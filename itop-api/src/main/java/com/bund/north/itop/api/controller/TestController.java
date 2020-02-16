package com.bund.north.itop.api.controller;

import com.bund.north.itop.api.service.TestService;
import com.bund.north.itop.common.entity.CommonResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService testService;

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
}
