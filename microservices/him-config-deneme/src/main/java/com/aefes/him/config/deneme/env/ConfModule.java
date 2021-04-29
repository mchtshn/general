package com.aefes.him.config.deneme.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;


import java.util.ArrayList;
import java.util.List;

import com.aefes.lib.utility.env.EnvUtility;
import com.aefes.lib.utility.util.Pair;
import com.aefes.lib.utility.log.MsLogger;
import com.aefes.lib.utility.log.MsLoggerFactory;

@Component("config-denemeConfModule")
public class ConfModule extends EnvUtility {

    @Autowired
    @Qualifier("config-denemeEnvModule")
    private EnvModule envModule;

    private static final MsLogger logger = MsLoggerFactory.getLogger(ConfModule.class);

    /** CONFIGMAP **/
    public String moduleIsActive() {
        return getEnv(EnvParamsModule.CONFIG-DENEME_MODULE_IS_ACTIVE);
    }


    @PostConstruct
    public void printCalculatedProperties() {
        List<Pair<String, String>> calculatedPropertyList = new ArrayList<>();

        calculatedPropertyList.add(Pair.of("moduleIsActive", moduleIsActive()));


        printCalculatedProperties(logger, calculatedPropertyList);
    }

}