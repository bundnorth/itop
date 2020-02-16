package com.bund.north.itop.api.controller;

import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.request.LoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: hugo0129
 * @Date: 2020/1/18
 * @Description 登录相关
 */
@Api(tags = {"LoginController"})
@RestController
@RequestMapping("/login")
public class LoginController {

	@ApiOperation(value = "sayHello测试")
	@GetMapping("/sayHello")
	public CommonResponse<String> sayHello(String name) {
		String data = "Welcome to Spring Cloud World," + name;
		return CommonResponse.success(data);
	}

	/**
	 * 生成普通的登录验证码
	 */

	@PostMapping("/mobile")
	public CommonResponse<Boolean> loginByMobile() {
		return CommonResponse.success(true);
	}

	@PostMapping("/custom")
	public CommonResponse<Boolean> login(@RequestBody LoginRequest request) {
		return CommonResponse.success(true);
	}

}
