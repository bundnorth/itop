package com.bund.north.itop.api.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hugo0129
 * @Date: 2020/1/18
 * @Description 登录相关
 */
@Api(tags = {"LoginController"})
@RestController("/login")
public class LoginController {

	@GetMapping("/sayHello")
	public String sayHello(String name) {
		return "Welcome to Spring Cloud World," + name;
	}
}
