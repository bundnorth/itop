package com.bund.north.itop.api.clients.user;

import com.bund.north.itop.api.clients.user.fallback.UserClientFallbackFactory;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "itop-user", fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {
	@GetMapping("/hello/say")
	String sayHello();

	@PostMapping("/member/add")
	CommonResponse<Boolean> addMember(@RequestBody Member member);

	@PostMapping("/member/get/one")
	CommonResponse<Member> getMemberByCondition(@RequestBody Member member);

	@GetMapping(value = "/member/get/all")
	CommonResponse<List<Member>> getAllMembers();
}
