package com.bund.north.itop.api.service.impl;

import com.bund.north.itop.api.exception.BusinessException;
import com.bund.north.itop.api.service.MemberService;
import com.bund.north.itop.api.service.MessageService;
import com.bund.north.itop.api.service.RegisterService;
import com.bund.north.itop.api.utils.RedisUtil;
import com.bund.north.itop.model.entity.Member;
import com.bund.north.itop.model.request.EmailRegisterRequest;
import com.bund.north.itop.model.request.MobileRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bund.north.itop.common.constant.SystemErrorMessage.VERIFY_CODE_ERROR;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private MemberService memberService;

	@Autowired
	private MessageService messageService;

	@Override
	public Boolean byEmail(EmailRegisterRequest request) {
		Member member = new Member();
		member.setUsername(request.getUsername());
		member.setPassword(request.getPassword());
		member.setEmail(request.getEmail());
		messageService.sendEmailVerifyCode(request);
		return memberService.addMember(member);
	}

	@Override
	public Boolean byMobile(MobileRegisterRequest request) {
		String code = RedisUtil.getStringRedis("register:" + request.getMobile());
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
