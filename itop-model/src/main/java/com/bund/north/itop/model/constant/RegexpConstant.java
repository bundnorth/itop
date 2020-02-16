package com.bund.north.itop.model.constant;

/**
 * 正则表达式常量
 */
public interface RegexpConstant {
	/**
	 * 邮箱地址
	 */
	String E_MAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	/**
	 * 手机号
	 */
	String MOBILE = "^1[0-9]{10}$";

}
