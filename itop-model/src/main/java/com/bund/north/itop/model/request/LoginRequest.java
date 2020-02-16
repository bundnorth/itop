package com.bund.north.itop.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginRequest {
	@ApiModelProperty("电子邮箱")
	private String email;

	@ApiModelProperty("密码")
	private String password;
}
