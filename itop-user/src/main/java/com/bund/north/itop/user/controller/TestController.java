package com.bund.north.itop.user.controller;

import com.bund.north.itop.common.entity.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Hsiung
 * @Date: 2020/1/20 17:18
 * @Description TODO
 */
@Api(tags = {"TestController"})
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

	@ApiOperation(value = "welcome")
	@GetMapping("/say")
	public CommonResponse<String> say() {
		return CommonResponse.success("Welcome to Spring Cloud World");
	}

	@ApiOperation(value = "sayHello测试")
	@GetMapping("/sayHello")
	public CommonResponse<String> sayHello(@RequestParam(name = "name") String name) {
		String data = "Welcome to Spring Cloud World," + name;
		return CommonResponse.success(data);
	}

	@GetMapping("/timeOut")
	public CommonResponse<String> timeOut(@RequestParam(name = "mills") int mills) {
		log.info("timeout测试，收到请求，阻塞[{}]", mills);
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("timeout测试，返回请求");
		return CommonResponse.success("timeout测试成功");
	}
}
