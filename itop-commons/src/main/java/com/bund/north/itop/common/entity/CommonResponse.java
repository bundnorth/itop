package com.bund.north.itop.common.entity;

import lombok.Data;

import static com.bund.north.itop.common.enumeration.SystemEnum.SYSTEM_ERROR;
import static com.bund.north.itop.common.enumeration.SystemEnum.SYSTEM_SUCCESS;

/**
 * @Author: Hsiung
 * @Date: 2020/1/18 15:48
 * @Description 统一response实体类
 */
@Data
public class CommonResponse<T> {
	/**
	 * 响应码
	 */
	private String code;
	/**
	 * 响应消息
	 */
	private String message;
	/**
	 * 响应数据
	 */
	private T data;

	CommonResponse() {
	}


	CommonResponse(String code, String message) {
		this(code, message, null);
	}

	CommonResponse(String code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	CommonResponse(T data) {
		this.code = SYSTEM_SUCCESS.getCode();
		this.message = SYSTEM_SUCCESS.getMessage();
		this.data = data;
	}

	public static <T> CommonResponse<T> success(T data) {
		return new CommonResponse<>(data);
	}

	public static <T> CommonResponse<T> failed(T data) {
		return new CommonResponse<>(SYSTEM_ERROR.getCode(), SYSTEM_ERROR.getMessage(), data);
	}

}