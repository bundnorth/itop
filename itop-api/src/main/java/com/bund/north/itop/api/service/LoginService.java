package com.bund.north.itop.api.service;

import com.bund.north.itop.model.request.LoginRequest;

public interface LoginService {
	String sendLoginCode(String mobile);

	Boolean login(LoginRequest request);

	Boolean loginByMobile(String mobile, String code);
}
