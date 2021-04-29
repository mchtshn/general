package com.aefes.him.demo.config;

import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.aefes.him.demo.model.SampleResponseDto;

@Configuration("demo")
@ComponentScan(basePackages = {"com.aefes.him.demo"})
public class ConfigMain implements WebMvcConfigurer {

    @Bean("sampleResponseFormatter")
    public JacksonDataFormat sampleResponseFormatter() {
        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(SampleResponseDto.class);
        jacksonDataFormat.setPrettyPrint(true);
        return jacksonDataFormat;
    }
}
