package com.bund.north.itop.model.request;

import com.bund.north.itop.model.constant.RegexpConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static com.bund.north.itop.model.constant.RegexpConstant.E_MAIL;

@Data
public class EmailRegisterRequest {
	@ApiModelProperty("电子邮箱")
	@NotNull(message = "电子邮箱不能为空")
	@Pattern(regexp = E_MAIL, message = "邮箱格式不正确")
	private String email;

	@ApiModelProperty("用户名")
	@NotNull(message = "用户名不能为空")
	private String username;

	@ApiModelProperty("密码")
	@NotNull(message = "密码不能为空")
	private String password;
}
