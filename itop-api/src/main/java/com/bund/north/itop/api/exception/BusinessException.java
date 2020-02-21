package com.bund.north.itop.api.exception;

import com.bund.north.itop.common.constant.SystemErrorMessage;
import com.bund.north.itop.common.enumeration.SystemErrorEnum;

import static com.bund.north.itop.common.enumeration.SystemErrorEnum.SYSTEM_ERROR;

public class BusinessException extends RuntimeException {
	private String code;
	private String message;

	public BusinessException(String message) {
		this.code = SYSTEM_ERROR.getCode();
		this.message = message;
	}

	public BusinessException(SystemErrorMessage systemErrorMessage) {
		this.code = systemErrorMessage.getCode();
		this.message = systemErrorMessage.getMessage();
	}

	public BusinessException(SystemErrorEnum systemEnum) {
		this.code = systemEnum.getCode();
		this.message = systemEnum.getMessage();
	}
}
