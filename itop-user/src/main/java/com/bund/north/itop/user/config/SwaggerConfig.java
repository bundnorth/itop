package com.bund.north.itop.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: Hsiung
 * @Date: 2020/1/20 14:11
 * @Description TODO
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bund.north.itop.user.controller"))
				.paths(PathSelectors.any())
				.build()
				.tags(new Tag("MemberController", "会员模块"),
						new Tag("TestController", "测试模块"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("itop-user API")
				.description("itop-user API reference for developers")
				.contact(new Contact("Hugo", "https://github.com/bundnorth/itop", "hugolovefreedom@gmail.com"))
				.version("1.0")
				.build();
	}
}
