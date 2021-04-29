package com.aefes.him.config.deneme.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.aefes.him.config.deneme.model.SampleRequestDto;

@Component
public class SampleRequestProcessor implements Processor {

	@Override
	public void process(Exchange exchange) {
		SampleRequestDto sampleRequestDto = exchange.getIn().getBody(SampleRequestDto.class);
		
		Object dominoReqObject = new Object();
		
		exchange.getMessage().setBody(dominoReqObject);
	}

}