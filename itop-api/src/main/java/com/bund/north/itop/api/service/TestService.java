package com.bund.north.itop.api.service;

public interface TestService {
	String say();

	String sayHello(String name);

	String timeOut(int mills);

	String hystrix(int mills);
}
