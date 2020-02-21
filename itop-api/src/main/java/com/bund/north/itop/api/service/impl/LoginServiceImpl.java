package com.bund.north.itop.api.service.impl;

import com.bund.north.itop.api.exception.BusinessException;
import com.bund.north.itop.api.service.LoginService;
import com.bund.north.itop.api.service.MemberService;
import com.bund.north.itop.api.service.MessageService;
import com.bund.north.itop.api.redis.RedisCacheUtil;
import com.bund.north.itop.model.entity.Member;
import com.bund.north.itop.model.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.bund.north.itop.common.constant.SystemConstant.redisPrefix.LOGIN_KEY_PREFIX;
import static com.bund.north.itop.common.constant.SystemConstant.redisPrefix.USER_KEY_PREFIX;
import static com.bund.north.itop.common.constant.SystemErrorMessage.*;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private MessageService messageService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private RedisCacheUtil redisCacheUtil;

	@Override
	public String sendLoginCode(String mobile) {
		return messageService.sendMobileVerifyCode("login", mobile);
	}

	@Override
	public Boolean login(LoginRequest request) {
		Member member = redisCacheUtil.get(USER_KEY_PREFIX, request.getEmail(), Member.class);
		if (Objects.isNull(member)) {
			member = memberService.getMemberByCondition(new Member().setEmail(request.getEmail()));
			if (Objects.isNull(member)) {
				throw new BusinessException(EMAIL_NOT_EXIST);
			}
			redisCacheUtil.set(USER_KEY_PREFIX, request.getEmail(), member, 60);
		}
		Boolean flag = request.getPassword().equals(member.getPassword());
		if (!flag) {
			throw new BusinessException(PASSWORD_ERROR);
		}
		return true;
	}

	@Override
	public Boolean loginByMobile(String mobile, String code) {
		Member member = redisCacheUtil.get(USER_KEY_PREFIX, mobile, Member.class);
		if (Objects.isNull(member)) {
			member = memberService.getMemberByCondition(new Member().setPhone(mobile));
			if (Objects.isNull(member)) {
				throw new BusinessException(MOBILE_NOT_EXIST);
			}
			redisCacheUtil.set(USER_KEY_PREFIX, mobile, member, 60);
		}
		String redisCode = redisCacheUtil.get(LOGIN_KEY_PREFIX, mobile, String.class);
		Boolean flag = code.equals(redisCode);
		if (!flag) {
			throw new BusinessException(VERIFY_CODE_ERROR);
		}
		return true;
	}
}
