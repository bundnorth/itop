package com.bund.north.itop.api.service;

import com.bund.north.itop.model.entity.Member;

public interface MemberService {
    Boolean addMember(Member member);

    Member getMemberByCondition(Member member);
}
