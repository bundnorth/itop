package com.bund.north.itop.api.service.impl;

import com.bund.north.itop.api.exception.BusinessException;
import com.bund.north.itop.api.service.MemberService;
import com.bund.north.itop.api.service.MessageService;
import com.bund.north.itop.api.service.RegisterService;
import com.bund.north.itop.api.redis.RedisCacheUtil;
import com.bund.north.itop.model.entity.Member;
import com.bund.north.itop.model.request.EmailRegisterRequest;
import com.bund.north.itop.model.request.MobileRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.bund.north.itop.common.constant.SystemConstant.redisPrefix.REGISTER_KEY_PREFIX;
import static com.bund.north.itop.common.constant.SystemErrorMessage.*;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private MemberService memberService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private RedisCacheUtil redisCacheUtil;

	@Override
	public Boolean byEmail(EmailRegisterRequest request) {
		Member exist = memberService.getMemberByCondition(new Member().setEmail(request.getEmail()));
		if (Objects.nonNull(exist)) {
			throw new BusinessException(EMAIL_EXISTS);
		}
		Member member = new Member();
		member.setUsername(request.getUsername());
		member.setPassword(request.getPassword());
		member.setEmail(request.getEmail());
		messageService.sendEmailVerifyCode(request);
		return memberService.addMember(member);
	}

	@Override
	public Boolean byMobile(MobileRegisterRequest request) {
		Member exist = memberService.getMemberByCondition(new Member().setPhone(request.getMobile()));
		if (Objects.nonNull(exist)) {
			throw new BusinessException(MOBILE_EXISTS);
		}
		String code = redisCacheUtil.get(REGISTER_KEY_PREFIX, request.getMobile(), String.class);
		Member member = new Member();
		member.setPhone(request.getMobile());
		if (request.getVerifyCode().equals(code)) {
			return memberService.addMember(member);
		} else {
			throw new BusinessException(VERIFY_CODE_ERROR);
		}
	}

	@Override
	public String sendMobileCode(String mobile) {
		return messageService.sendMobileVerifyCode("register", mobile);
	}
}
