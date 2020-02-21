package com.bund.north.itop.common.constant;

/**
 * @Author: Hsiung
 * @Date: 2020/1/18 15:48
 * @Description 系统常量值
 */
public interface SystemConstant {
	/**
	 * 成功
	 */
	String SUCCESS = "200";

	/**
	 * 错误
	 */
	String ERROR = "500";

	interface redisPrefix {
		String USER_KEY_PREFIX = "user:";
		String REGISTER_KEY_PREFIX = "register:";
		String LOGIN_KEY_PREFIX = "login:";
	}
}
