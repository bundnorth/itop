package com.bund.north.itop.api.controller;

import com.bund.north.itop.common.entity.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

	@ApiOperation(value = "sayHello测试")
	@GetMapping("/sayHello")
	public CommonResponse<String> sayHello(String name) {
		String data = "Welcome to Spring Cloud World," + name;
		return CommonResponse.success(data);
	}

}
