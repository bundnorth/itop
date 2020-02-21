package com.bund.north.itop.api.exception;

import com.bund.north.itop.common.entity.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.bund.north.itop.common.constant.SystemErrorMessage.BIND_ERROR;
import static com.bund.north.itop.common.constant.SystemErrorMessage.SERVER_ERROR;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public CommonResponse<String> exceptionHandler(HttpServletRequest request, Exception e) {
		e.fillInStackTrace();
		if (e instanceof BusinessException) {
			BusinessException ex = (BusinessException) e;
			return CommonResponse.failed(ex.getCode(), ex.getMessage());
		} else if (e instanceof BindException) {
			BindException ex = (BindException) e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			String msg = error.getDefaultMessage();
			return CommonResponse.failed(BIND_ERROR.fillArgs(msg));
		} else {
			return CommonResponse.failed(SERVER_ERROR);
		}
	}
}
