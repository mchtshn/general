package com.mucahit.dependencyinjection.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;


@ConfigurationProperties(prefix = "datasource")
@ConstructorBinding
@Getter
public class ConstructorConfiguration {

    private final String username;
    private final String password;
    private final String jdbcurl;

    public ConstructorConfiguration(String username, String password, String jdbcurl) {
        this.username = username;
        this.password = password;
        this.jdbcurl = jdbcurl;
    }
}
