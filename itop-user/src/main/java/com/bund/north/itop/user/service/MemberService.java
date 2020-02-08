package com.bund.north.itop.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bund.north.itop.user.entity.Member;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author hugo0129
 * @since 2020-01-19
 */
public interface MemberService extends IService<Member> {
    Boolean addMember(Member member);
}
