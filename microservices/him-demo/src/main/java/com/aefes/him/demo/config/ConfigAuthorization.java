package com.aefes.him.demo.config;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.aefes.lib.utility.log.MsLogger;
import com.aefes.lib.utility.log.MsLoggerFactory;

@Component("demoAuthorization")
public class ConfigAuthorization {

    private static final MsLogger logger = MsLoggerFactory.getLogger(ConfigAuthorization.class);

    @PreAuthorize("hasRole('ROLE_him-salesdocument')")
    public void hasDemoRole() {
        logger.info("user has him-demo role");
    }
}
