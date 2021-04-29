package com.aefes.him.demo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.aefes.him.demo.model.SampleDto;
import com.aefes.him.demo.model.SampleResponseDto;
import com.aefes.lib.cdm.model.dto.base.BaseBodyDto;

@Component
public class SampleResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {
        Object sampleResObject = exchange.getMessage().getBody(Object.class);

        SampleResponseDto sampleResponseDto = new SampleResponseDto();
        sampleResponseDto.setBody(new BaseBodyDto<>());
        SampleDto sampleDto = new SampleDto();
        sampleDto.setInfo("produced by archetype");
        sampleResponseDto.getBody().setCdmDto(sampleDto);

        exchange.getMessage().setBody(sampleResponseDto);
    }
}
