package com.bund.north.itop.api.clients.user;

import com.bund.north.itop.api.clients.user.fallback.UserClientFallbackFactory;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "itop-user", fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {

    @PostMapping("/member/add")
    CommonResponse<Boolean> addMember(@RequestBody Member member);

    @PostMapping("/member/get/one")
    CommonResponse<Member> getMemberByCondition(@RequestBody Member member);
}
