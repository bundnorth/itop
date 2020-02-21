package com.bund.north.itop.api.exception;

import com.bund.north.itop.common.constant.SystemErrorMessage;
import com.bund.north.itop.common.entity.CommonResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public CommonResponse<String> exceptionHandler(HttpServletRequest request, Exception e) {
		e.fillInStackTrace();
		if (e instanceof GlobalException) {
			GlobalException ex = (GlobalException) e;
			return CommonResponse.failed(ex.getSystemErrorMessage());
		} else if (e instanceof BindException) {
			BindException ex = (BindException) e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			String msg = error.getDefaultMessage();
			return CommonResponse.failed(SystemErrorMessage.BIND_ERROR.fillArgs(msg));
		} else {
			return CommonResponse.failed(SystemErrorMessage.SERVER_ERROR);
		}
	}
}
