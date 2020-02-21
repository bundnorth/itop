package com.bund.north.itop.common.enumeration;

/**
 * @Author: Hsiung
 * @Date: 2020/1/18 15:49
 * @Description 系统错误枚举类
 */
public enum SystemErrorEnum {
	/**
	 * 系统错误，请重试
	 */
	SYSTEM_ERROR("500", "系统错误，请重试"),

	/**
	 * 成功响应
	 */
	SYSTEM_SUCCESS("200", "成功");

	/**
	 * 错误码
	 */
	private String code;
	/**
	 * 错误信息
	 */
	private String message;

	SystemErrorEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
