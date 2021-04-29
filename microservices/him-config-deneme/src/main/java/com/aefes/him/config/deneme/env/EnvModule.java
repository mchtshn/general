package com.aefes.him.config.deneme.env;

import com.aefes.lib.utility.log.MsLogger;
import com.aefes.lib.utility.log.MsLoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.aefes.lib.utility.env.YamlPropertySourceFactory;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.PostConstruct;

@Component("config-denemeEnvModule")
//@ConfigurationProperties(prefix = "config-deneme")
//@PropertySource(value = "classpath:him-config-deneme-${spring.profiles.active}.yml",factory = YamlPropertySourceFactory.class)
@Setter
@Getter
@ToString
public class EnvModule {
	
	private static final MsLogger logger = MsLoggerFactory.getLogger(EnvModule.class);



	@PostConstruct
	public void printYamlProperties() {
		logger.info(this.toString());
	}
	
}