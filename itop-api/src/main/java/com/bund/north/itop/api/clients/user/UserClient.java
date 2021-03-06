package com.bund.north.itop.api.clients.user;

import com.bund.north.itop.api.clients.user.fallback.UserClientFallbackFactory;
import com.bund.north.itop.api.config.FeignConfig;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "itop-user", configuration = FeignConfig.class, fallbackFactory = UserClientFallbackFactory.class)
//@FeignClient(name = "itop-user", fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {
	@GetMapping("/test/timeOut")
	CommonResponse<String> timeOut(@RequestParam(name = "mills") int mills);

	@GetMapping("/test/say")
	CommonResponse<String> say();

	@GetMapping("/test/sayHello")
	CommonResponse<String> sayHello(@RequestParam(name = "name") String name);

	@PostMapping("/member/add")
	CommonResponse<Boolean> addMember(@RequestBody Member member);

	@PostMapping("/member/update/one")
	CommonResponse<Boolean> updateMember(@RequestBody Member member);

	@PostMapping("/member/get/one")
	CommonResponse<Member> getMemberByCondition(@RequestBody Member member);

	@GetMapping(value = "/member/get/all")
	CommonResponse<List<Member>> getAllMembers();
}
