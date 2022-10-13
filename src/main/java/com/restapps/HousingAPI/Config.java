package com.restapps.HousingAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.restapps.HousingAPI.service.AgentService;
import com.restapps.HousingAPI.service.AgentServiceImpl;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config {
	
	@Bean
	public Docket getdocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.restapps.HousingAPI"))
				.build();
	}
	
	@Bean
	public AgentService agentService() {
	    return new AgentServiceImpl();
	}

}
