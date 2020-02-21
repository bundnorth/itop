package com.bund.north.itop.common.utils;

import java.util.Random;
import java.util.UUID;

public class GenerateCodeUtil {
	/**
	 * 生成邮箱激活码
	 *
	 * @param prefix
	 * @return
	 */
	public static String getEmailActiveCode(String prefix) {
		String code = prefix + UUID.randomUUID().toString().replaceAll("-", "");
		return code.substring(0, 6);
	}

	/**
	 * 短信验证码
	 *
	 * @param length 长度
	 * @return
	 */
	public static String getMobileActiveCode(Integer length) {
		StringBuilder code = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			code.append(random.nextInt(10));
		}
		return code.toString();
	}
}
