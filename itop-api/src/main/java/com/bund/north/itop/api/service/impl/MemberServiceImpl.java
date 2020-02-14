package com.bund.north.itop.api.service.impl;

import com.bund.north.itop.api.clients.user.UserClient;
import com.bund.north.itop.api.service.MemberService;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.entity.Member;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("memberService")
@Slf4j
public class MemberServiceImpl implements MemberService {
	@Autowired
	private RestTemplate restTemplate;

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
	@HystrixCommand(fallbackMethod = "fallbackMember")
	public Member getMemberByCondition(Member member) {
		CommonResponse<Member> result = userClient.getMemberByCondition(member);
		return result.getData();
	}

	@Override
	public List<Member> getAllMembers() {
		CommonResponse<List<Member>> result = userClient.getAllMembers();
		return result.getData();
	}

	@Override
	@HystrixCommand(fallbackMethod = "fallbackMember")
	public Member hystrixMember(Member member) {
		// restTemplate直连方式，调用远程服务
		return (Member) this.restTemplate.postForObject("http://localhost:8083/member/get/one", null, CommonResponse.class, member).getData();
	}

	public Member fallbackMember(Member member) {
		log.info("Exception occured, enter fallback with param:id[{}]", member.getId());
		member.setNickname("default username");
		return member;
	}
}
