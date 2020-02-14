package com.bund.north.itop.api.clients.user;

import com.bund.north.itop.api.clients.user.fallback.UserClientFallbackFactory;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "itop-user", fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {
	@RequestMapping(value = "/itop-user/hello/say", method = RequestMethod.GET)
	String sayHello();

	@RequestMapping(value = "/itop-user/member/add", method = RequestMethod.POST)
	CommonResponse<Boolean> addMember(@RequestBody Member member);

	@RequestMapping(value = "/itop-user/member/get/one", method = RequestMethod.POST)
	CommonResponse<Member> getMemberByCondition(@RequestBody Member member);

	@RequestMapping(value = "/itop-user/member/get/all", method = RequestMethod.GET)
	CommonResponse<List<Member>> getAllMembers();
}
