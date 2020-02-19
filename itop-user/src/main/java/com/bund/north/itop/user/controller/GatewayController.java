package com.bund.north.itop.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway-user")
@Slf4j
public class GatewayController {

	@GetMapping("/message")
	public String message(@RequestHeader("second-request") String header) {
		log.info("Get second-request header: " + header);
		return "Hello Gateway Called in gateway-user";
	}
}