package com.aefes.him.demo.model;

import com.aefes.lib.cdm.model.dto.base.BaseCdmDto;
import com.aefes.lib.cdm.model.dto.base.JsonRoot;
import com.aefes.lib.cdm.model.dto.base.Resource;
import com.aefes.lib.utility.exception.MsBusinessException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleDto extends BaseCdmDto {

    private String info;

    @Override
    public String jsonRoot() {
        return JsonRoot.SAMPLE;
    }

    @Override
    public Resource resource() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void validate() throws MsBusinessException {
        // TODO Auto-generated method stub

    }
}
