package com.bund.north.itop.api.service;

import com.bund.north.itop.model.request.EmailRegisterRequest;
import com.bund.north.itop.model.request.MobileRegisterRequest;

public interface RegisterService {
	Boolean byEmail(EmailRegisterRequest request);

	Boolean byMobile(MobileRegisterRequest request);

	String sendMobileCode(String mobile);
}
