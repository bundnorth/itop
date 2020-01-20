package com.bund.north.itop.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bund.north.itop.dao.entity.Member;
import com.bund.north.itop.dao.mapper.MemberMapper;
import com.bund.north.itop.dao.service.MemberService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author hugo0129
 * @since 2020-01-19
 */
@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
