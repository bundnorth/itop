package com.bund.north.itop.api.service.impl;

import com.bund.north.itop.api.service.MemberService;
import com.bund.north.itop.api.service.MessageService;
import com.bund.north.itop.api.service.RegisterService;
import com.bund.north.itop.model.entity.Member;
import com.bund.north.itop.model.request.EmailRegisterRequest;
import com.bund.north.itop.model.request.MobileRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Member member = new Member();
		member.setPhone(request.getMobile());
		return memberService.addMember(member);
	}

	@Override
	public String sendEmailCode(String email) {

		return null;
	}

	@Override
	public Boolean sendMobileCode(String mobile) {
		messageService.sendMobileVerifyCode(mobile);
		return null;
	}
}
