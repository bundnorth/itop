package com.bund.north.itop.api.exception;

import com.bund.north.itop.common.constant.CodeMessage;
import lombok.Data;

@Data
public class GlobalException extends RuntimeException {
	private CodeMessage codeMessage;

	public GlobalException(CodeMessage codeMessage) {
		super(codeMessage.toString());
		this.codeMessage = codeMessage;
	}
}
