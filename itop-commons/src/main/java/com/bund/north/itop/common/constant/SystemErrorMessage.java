package com.bund.north.itop.common.constant;

import lombok.Data;

@Data
public class SystemErrorMessage {

	private String code;
	private String message;

	public static SystemErrorMessage SUCCESS = new SystemErrorMessage("200", "success");
	/**
	 * 系统通用的错误码 5001XX
	 */
	public static SystemErrorMessage SERVER_ERROR = new SystemErrorMessage("500100", "服务端异常");
	public static SystemErrorMessage BIND_ERROR = new SystemErrorMessage("500101", "参数校验异常：%s");
	public static SystemErrorMessage REQUEST_ILLEGAL = new SystemErrorMessage("500102", "请求非法");
	public static SystemErrorMessage ACCESS_LIMIT_REACHED = new SystemErrorMessage("500104", "访问太频繁！");

	/**
	 * 登录模块 5002XX
	 */
	public static SystemErrorMessage SESSION_ERROR = new SystemErrorMessage("500210", "Session不存在或者已经失效");
	public static SystemErrorMessage PASSWORD_EMPTY = new SystemErrorMessage("500211", "登录密码不能为空");
	public static SystemErrorMessage MOBILE_EMPTY = new SystemErrorMessage("500212", "手机号不能为空");
	public static SystemErrorMessage MOBILE_ERROR = new SystemErrorMessage("500213", "手机号格式错误");
	public static SystemErrorMessage MOBILE_NOT_EXIST = new SystemErrorMessage("500214", "手机号不存在");
	public static SystemErrorMessage EMAIL_NOT_EXIST = new SystemErrorMessage("500215", "用户不存在");
	public static SystemErrorMessage PASSWORD_ERROR = new SystemErrorMessage("500216", "密码错误");
	public static SystemErrorMessage VERIFY_CODE_ERROR = new SystemErrorMessage("500217", "验证码错误");


	//商品模块 5003XX

	//订单模块 5004XX
	public static SystemErrorMessage ORDER_NOT_EXIST = new SystemErrorMessage("500400", "订单不存在");

	private SystemErrorMessage(String code, String msg) {
		this.code = code;
		this.message = msg;
	}

	public SystemErrorMessage fillArgs(Object... args) {
		String code = this.code;
		String message = String.format(this.message, args);
		return new SystemErrorMessage(code, message);
	}

	@Override
	public String toString() {
		return "CodeMessage [code=" + code + ", message=" + message + "]";
	}

}
