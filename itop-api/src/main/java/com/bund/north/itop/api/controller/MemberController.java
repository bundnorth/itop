package com.bund.north.itop.api.controller;

import com.bund.north.itop.api.service.MemberService;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.entity.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Hsiung
 * @Date: 2020/1/20 18:06
 * @Description 会员模块
 */
@Api(tags = {"MemberController"})
@RestController
@RequestMapping("/member")
public class MemberController {

	@Resource
	private MemberService memberService;

	@GetMapping("/say")
	public CommonResponse<String> sayHello() {
		return CommonResponse.success(memberService.sayHello());
	}

	@ApiOperation(value = "新增会员")
	@PostMapping("/add")
	public CommonResponse<Boolean> addMember(@RequestBody Member member) {
		return CommonResponse.success(memberService.addMember(member));
	}

	@ApiOperation(value = "查找会员")
	@PostMapping("/get/one")
	public CommonResponse<Member> getMemberByCondition(@RequestBody Member member) {
		return CommonResponse.success(memberService.getMemberByCondition(member));
	}

	@ApiOperation(value = "获取会员列表")
	@PostMapping("/get/all")
	public CommonResponse<List<Member>> getAllMembers() {
		return CommonResponse.success(memberService.getAllMembers());
	}

	@ApiOperation(value = "测试熔断器")
	@GetMapping("/hystrix/{id}")
	public CommonResponse<Member> hystrixMember(@PathVariable Long id) {
		Member member = new Member();
		member.setId(id);
		return CommonResponse.success(memberService.hystrixMember(member));
	}


}
