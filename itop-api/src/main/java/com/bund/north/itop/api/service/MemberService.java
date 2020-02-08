package com.bund.north.itop.api.service;

import com.bund.north.itop.model.entity.Member;
import org.springframework.stereotype.Service;

@Service("memberService")
public interface MemberService {
    Boolean addMember(Member member);

    Member getMemberByCondition(Member member);
}
