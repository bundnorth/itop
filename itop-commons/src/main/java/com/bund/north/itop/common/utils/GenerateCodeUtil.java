package com.bund.north.itop.common.utils;

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
}
