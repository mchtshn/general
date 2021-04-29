package com.aefes.him.config.deneme.config;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.aefes.lib.utility.log.MsLogger;
import com.aefes.lib.utility.log.MsLoggerFactory;

@Component("config-denemeAuthorization")
public class ConfigAuthorization {
	
	private static final MsLogger logger = MsLoggerFactory.getLogger(ConfigAuthorization.class);
	
	@PreAuthorize("hasRole('ROLE_him-config-deneme')")
	public void hasConfig-denemeRole() {
		logger.info("user has him-config-deneme role");
	}

}