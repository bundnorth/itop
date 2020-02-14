package com.bund.north.itop.api.service.impl;

import com.bund.north.itop.api.clients.user.UserClient;
import com.bund.north.itop.api.service.MemberService;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private UserClient userClient;

	@Override
	public String sayHello() {
		return userClient.sayHello();
	}

	@Override
	public Boolean addMember(Member member) {
		CommonResponse<Boolean> result = userClient.addMember(member);
		return result.getData();
	}

	@Override
	public Member getMemberByCondition(Member member) {
		CommonResponse<Member> result = userClient.getMemberByCondition(member);
		return result.getData();
	}

	@Override
	public List<Member> getAllMembers() {
		CommonResponse<List<Member>> result = userClient.getAllMembers();
		return result.getData();
	}
}
