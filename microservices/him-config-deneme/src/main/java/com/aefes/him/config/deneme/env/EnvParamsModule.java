package com.aefes.him.config.deneme.env;

import com.aefes.lib.utility.env.EnvParam;

public enum EnvParamsModule implements EnvParam {
	
	CONFIG-DENEME_MODULE_IS_ACTIVE;
	
	@Override
	public String value() {
		return this.name();
	}

}