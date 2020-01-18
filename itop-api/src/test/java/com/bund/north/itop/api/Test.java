package com.bund.north.itop.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Hsiung
 * @Date: 2020/1/18 14:31
 * @Description 简单测试
 */
public class Test {
	public static void main(String[] args) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date d1 = df.parse("2020-01-18T03:08:52.000+0000");
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d2 = df2.parse(df2.format(d1));
		System.out.println(d1);
		System.out.println(df2.format(d1));
		System.out.println(d2);
		System.out.println(d1.equals(d2));
	}
}
