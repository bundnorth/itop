package com.bund.north.itop.api.service;

import com.bund.north.itop.model.entity.Member;

import java.util.List;

public interface MemberService {
	String sayHello();

	Boolean addMember(Member member);

	Member getMemberByCondition(Member member);

	List<Member> getAllMembers();
}
