package com.bund.north.itop.api.exception;

import com.bund.north.itop.common.constant.SystemErrorMessage;
import lombok.Data;

@Data
public class GlobalException extends RuntimeException {
	private SystemErrorMessage systemErrorMessage;

	public GlobalException(SystemErrorMessage systemErrorMessage) {
		super(systemErrorMessage.toString());
		this.systemErrorMessage = systemErrorMessage;
	}
}
