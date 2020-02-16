package com.bund.north.itop.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static com.bund.north.itop.model.constant.RegexpConstant.MOBILE;

@Data
public class MobileRegisterRequest {
	@ApiModelProperty("手机号")
	@NotNull(message = "手机号不能为空")
	@Pattern(regexp = MOBILE, message = "手机号格式不正确")
	private String mobile;

	@ApiModelProperty("验证码")
	@NotNull(message = "验证码不能为空")
	private String verifyCode;
}
