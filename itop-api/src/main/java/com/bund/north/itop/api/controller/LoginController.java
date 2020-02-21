package com.bund.north.itop.api.controller;

import com.bund.north.itop.api.service.LoginService;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.request.LoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private LoginService loginService;

	/**
	 * 生成普通的登录验证码
	 */
	@ApiOperation("获取手机登录验证码")
	@GetMapping("/get/code")
	public CommonResponse<String> sendCode(@RequestParam("mobile") String mobile) {
		return CommonResponse.success(loginService.sendLoginCode(mobile));
	}

	@ApiOperation("手机号登录")
	@PostMapping("/mobile")
	public CommonResponse<Boolean> loginByMobile(@RequestParam("mobile") String mobile,
												 @RequestParam("code") String code) {
		return CommonResponse.success(loginService.loginByMobile(mobile, code));
	}

	@ApiOperation("用户名密码登录")
	@PostMapping("/custom")
	public CommonResponse<Boolean> login(@RequestBody LoginRequest request) {
		return CommonResponse.success(loginService.login(request));
	}

}
