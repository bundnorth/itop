package com.bund.north.itop.api.service.impl;

import com.bund.north.itop.api.exception.BusinessException;
import com.bund.north.itop.api.service.LoginService;
import com.bund.north.itop.api.service.MemberService;
import com.bund.north.itop.api.service.MessageService;
import com.bund.north.itop.api.utils.RedisUtil;
import com.bund.north.itop.model.entity.Member;
import com.bund.north.itop.model.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.bund.north.itop.common.constant.SystemErrorMessage.EMAIL_NOT_EXIST;
import static com.bund.north.itop.common.constant.SystemErrorMessage.MOBILE_NOT_EXIST;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private MessageService messageService;

	@Autowired
	private MemberService memberService;

	@Override
	public String sendLoginCode(String mobile) {
		return messageService.sendMobileVerifyCode("login", mobile);
	}

	@Override
	public Boolean login(LoginRequest request) {
		Member member = (Member) RedisUtil.getObjectRedis(request.getEmail());
		if (Objects.isNull(member)) {
			member = memberService.getMemberByCondition(new Member().setEmail(request.getEmail()));
			if (Objects.isNull(member)) {
				throw new BusinessException(EMAIL_NOT_EXIST);
			}
			RedisUtil.setRedis(request.getEmail(), member, 60);
		}
		return request.getPassword().equals(member.getPassword());
	}

	@Override
	public Boolean loginByMobile(String mobile, String code) {
		Member member = (Member) RedisUtil.getObjectRedis(mobile);
		if (Objects.isNull(member)) {
			member = memberService.getMemberByCondition(new Member().setPhone(mobile));
			if (Objects.isNull(member)) {
				throw new BusinessException(MOBILE_NOT_EXIST);
			}
			RedisUtil.setRedis(mobile, member, 60);
		}
		String redisCode = RedisUtil.getStringRedis("login" + ":" + mobile);
		return redisCode.equals(code);
	}
}
