package com.bund.north.itop.user.controller;
import com.bund.north.itop.common.entity.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Hsiung
 * @Date: 2020/1/20 17:18
 * @Description TODO
 */
@Api(tags = {"HelloController"})
@RestController
@RequestMapping("/hello")
public class HelloController {

	@ApiOperation(value = "sayHello测试")
	@GetMapping("/sayHello")
	public CommonResponse<String> sayHello(@RequestParam(name = "name") String name) {
		String data = "Welcome to Spring Cloud World," + name;
		return CommonResponse.success(data);
	}
}
