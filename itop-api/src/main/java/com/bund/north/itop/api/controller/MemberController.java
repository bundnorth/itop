package com.bund.north.itop.api.controller;

import com.bund.north.itop.api.service.MemberService;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.entity.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Hsiung
 * @Date: 2020/1/20 18:06
 * @Description TODO
 */
@Api(tags = {"MemberController"})
@RestController("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

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


}