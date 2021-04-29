package com.aefes.him.demo.env;

import com.aefes.lib.utility.env.EnvParam;

public enum EnvParamsModule implements EnvParam {
    DEMO_MODULE_IS_ACTIVE,
    SAMPLE_URI;

    @Override
    public String value() {
        return this.name();
    }
}
