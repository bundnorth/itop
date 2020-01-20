package com.bund.north.itop.dao.controller;


import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.dao.entity.Member;
import com.bund.north.itop.dao.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author hugo0129
 * @since 2020-01-19
 */
@Api(tags = {"MemberController"})
@RestController
@RequestMapping("/member")
public class MemberController {

	@Resource
	private MemberService memberService;

	@ApiOperation(value = "sayHello测试")
	@GetMapping("/sayHello")
	public CommonResponse<String> sayHello(String name) {
		String data = "Welcome to Spring Cloud World," + name;
		return CommonResponse.success(data);
	}
	
	@PostMapping("/add")
	@ApiOperation("增加会员")
	public CommonResponse<Boolean> addMember(@RequestBody Member member) {
		return CommonResponse.success(memberService.save(member));
	}
}
