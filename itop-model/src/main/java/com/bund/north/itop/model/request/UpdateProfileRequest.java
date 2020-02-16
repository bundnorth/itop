package com.bund.north.itop.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateProfileRequest {

	@ApiModelProperty(value = "会员号")
	private Long memberId;

	@ApiModelProperty(value = "用户名")
	private String username;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "昵称")
	private String nickname;

	@ApiModelProperty(value = "手机号码")
	private String phone;

	@ApiModelProperty("电子邮箱")
	private String email;

	@ApiModelProperty(value = "帐号启用状态:0->禁用；1->启用")
	private Integer status;

	@ApiModelProperty(value = "头像")
	private String icon;

	@ApiModelProperty(value = "性别：0->未知；1->男；2->女")
	private Integer gender;

	@ApiModelProperty(value = "生日")
	private LocalDate birthday;

	@ApiModelProperty(value = "所做城市")
	private String city;

	@ApiModelProperty(value = "职业")
	private String job;

	@ApiModelProperty(value = "个性签名")
	private String personalizedSignature;

	@ApiModelProperty(value = "用户来源")
	private Integer sourceType;

	@ApiModelProperty(value = "积分")
	private Integer integration;

	@ApiModelProperty(value = "成长值")
	private Integer growth;
}
