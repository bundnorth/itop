package com.bund.north.itop.api.service;

import com.bund.north.itop.model.request.EmailRegisterRequest;

public interface MessageService {
	void sendEmailVerifyCode(EmailRegisterRequest request);

	String sendMobileVerifyCode(String from, String mobile);
}
