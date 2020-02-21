package com.bund.north.itop.api.controller;

import com.bund.north.itop.api.service.MemberService;
import com.bund.north.itop.api.service.MineService;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.entity.Member;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 我的模块
 */
@RestController
@RequestMapping("/mine")
public class MineController {
	@Autowired
	private MemberService memberService;

	@Autowired
	private MineService mineService;

	@PostMapping("/update/basic")
	public CommonResponse<Boolean> updateProfile(@RequestBody Member member) {
		return CommonResponse.success(memberService.updateMember(member));
	}

	@ApiOperation("激活邮箱")
	@GetMapping("/active/email")
	public CommonResponse<Boolean> activeEmail(@RequestParam("email") String email,
											   @RequestParam("code") String code) {
		return CommonResponse.success(mineService.activeEmail(email, code));
	}
}
