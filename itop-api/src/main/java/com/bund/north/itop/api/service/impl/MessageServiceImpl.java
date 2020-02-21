package com.bund.north.itop.api.service.impl;

import com.bund.north.itop.api.service.MessageService;
import com.bund.north.itop.api.utils.RedisUtil;
import com.bund.north.itop.common.utils.GenerateCodeUtil;
import com.bund.north.itop.model.request.EmailRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("messageService")
@Slf4j
public class MessageServiceImpl implements MessageService {
	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.from}")
	private String mailFrom;

	@Override
	public void sendEmailVerifyCode(EmailRegisterRequest request) {
		String activeCode = GenerateCodeUtil.getEmailActiveCode("");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("请激活你的itop账号");
		message.setText("您好 " + request.getEmail() + ",祝贺您注册itop！" + "注册验证码是：" + activeCode);
		message.setTo(request.getEmail());
		message.setFrom(mailFrom);
		log.info(request.getEmail() + "获取邮箱验证码：" + activeCode);
		mailSender.send(message);
	}

	@Override
	// TODO 对接运营商短信发送平台
	public String sendMobileVerifyCode(String from, String mobile) {
		String code = GenerateCodeUtil.getMobileActiveCode(6);
		log.info(mobile + "手机验证码为：" + code + ";5分钟内有效");
		RedisUtil.setRedis(from + ":" + mobile, code, 5 * 60);
		return code;
	}
}
