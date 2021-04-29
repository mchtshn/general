package com.mucahit.dependencyinjection.config;


import com.mucahit.dependencyinjection.datasource.FakeDataSource;
import com.mucahit.dependencyinjection.services.ConstructorGreetingServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@EnableConfigurationProperties(ConstructorConfiguration.class)
@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingServiceImpl constructorGreetingServiceImpl() {
        return new ConstructorGreetingServiceImpl();
    }

    @Bean
    FakeDataSource fakeDataSource(@Value("${datasource.username}") String username,@Value("${datasource.password}") String password,@Value("${datasource.jdbcurl}") String jdbcurl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }
}
