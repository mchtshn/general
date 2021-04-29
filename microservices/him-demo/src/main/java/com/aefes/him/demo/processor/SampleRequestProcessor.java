package com.aefes.him.demo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.aefes.him.demo.model.SampleRequestDto;

@Component
public class SampleRequestProcessor implements Processor {

    @Autowired Environment environment;

    @Override
    public void process(Exchange exchange) {
        SampleRequestDto sampleRequestDto = exchange.getIn().getBody(SampleRequestDto.class);

        System.out.println("DADADA " + environment.getProperty("salesdocument.name"));

        Object dominoReqObject = new Object();

        exchange.getMessage().setBody(dominoReqObject);
    }
}
