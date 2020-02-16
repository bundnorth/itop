package com.bund.north.itop.api.controller;

import com.bund.north.itop.api.service.MemberService;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 我的模块
 */
@RestController
@RequestMapping("/mine")
public class MineController {
	@Autowired
	private MemberService memberService;

	@PostMapping("/update/basic")
	public CommonResponse<Boolean> updateProfile(@RequestBody Member member) {
		return CommonResponse.success(memberService.updateMember(member));
	}
}
