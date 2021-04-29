package com.aefes.him.config.deneme.config;

import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.aefes.him.config.deneme.model.SampleResponseDto;

@Configuration("config-deneme")
@ComponentScan(basePackages = { "com.aefes.him.config.deneme" })
public class ConfigMain implements WebMvcConfigurer {
	
	@Bean("sampleResponseFormatter")
	public JacksonDataFormat sampleResponseFormatter() {
		JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(SampleResponseDto.class);
		jacksonDataFormat.setPrettyPrint(true);
		return jacksonDataFormat;
	}
	
}