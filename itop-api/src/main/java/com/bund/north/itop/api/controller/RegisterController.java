package com.bund.north.itop.api.controller;

import com.bund.north.itop.api.service.RegisterService;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.request.EmailRegisterRequest;
import com.bund.north.itop.model.request.MobileRegisterRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 注册模块
 */
@RestController
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@PostMapping("/get/verify")
	@ApiOperation("获取验证码")
	public CommonResponse<String> getMobileCode(@RequestParam("mobile") String mobile) {
		return CommonResponse.success(registerService.sendMobileCode(mobile));
	}

	@PostMapping("/mobile")
	@ApiOperation("手机注册")
	public CommonResponse<Boolean> byMobile(@Validated @RequestBody MobileRegisterRequest request) {
		return CommonResponse.success(registerService.byMobile(request));
	}

	@PostMapping("/email")
	@ApiOperation("邮箱注册")
	public CommonResponse<Boolean> byEmail(@Validated @RequestBody EmailRegisterRequest request) {
		return CommonResponse.success(registerService.byEmail(request));
	}


}
