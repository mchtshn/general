package com.mucahit.dependencyinjection.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "datasource")
@Configuration
@Getter
@Setter
public class Configurationn {

    private String username;
    private String password;
    private String jdbcurl;
}
