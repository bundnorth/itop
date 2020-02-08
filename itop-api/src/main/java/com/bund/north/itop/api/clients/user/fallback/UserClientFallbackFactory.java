package com.bund.north.itop.api.clients.user.fallback;

import com.bund.north.itop.api.clients.user.UserClient;
import com.bund.north.itop.common.entity.CommonResponse;
import com.bund.north.itop.model.entity.Member;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable e) {
        return new UserClient() {
            @Override
            public CommonResponse<Boolean> addMember(Member member) {
                log.error("UserClient#addMember encounter a problem with param member:[{}]", member, e);
                return null;
            }

            @Override
            public CommonResponse<Member> getMemberByCondition(Member member) {
                log.error("UserClient#getMemberByCondition encounter a problem with param member:[{}]", member, e);
                return null;
            }
        };
    }
}
