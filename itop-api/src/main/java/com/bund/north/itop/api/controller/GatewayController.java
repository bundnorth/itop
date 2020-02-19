package com.bund.north.itop.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway-api")
@Slf4j
public class GatewayController {

	@GetMapping("/message")
	public String message(@RequestHeader("first-request") String header) {
		log.info("Get first-request header: " + header);
		return "Hello Gateway Called in gateway-api";
	}
}
