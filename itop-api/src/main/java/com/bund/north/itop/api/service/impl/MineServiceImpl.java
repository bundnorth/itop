package com.bund.north.itop.api.service.impl;

import com.bund.north.itop.api.exception.BusinessException;
import com.bund.north.itop.api.service.MineService;
import com.bund.north.itop.api.redis.RedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bund.north.itop.common.constant.SystemConstant.redisPrefix.REGISTER_KEY_PREFIX;
import static com.bund.north.itop.common.constant.SystemErrorMessage.VERIFY_CODE_ERROR;

@Service("mineService")
public class MineServiceImpl implements MineService {
	@Autowired
	private RedisCacheUtil redisCacheUtil;


	@Override
	public Boolean activeEmail(String email, String code) {
		String activeCode = redisCacheUtil.get(REGISTER_KEY_PREFIX, email, String.class);
		Boolean active = code.equals(activeCode);
		if (!active) {
			throw new BusinessException(VERIFY_CODE_ERROR);
		}
		return true;
	}
}
