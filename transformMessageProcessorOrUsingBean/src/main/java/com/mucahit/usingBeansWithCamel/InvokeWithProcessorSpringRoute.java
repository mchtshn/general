package com.mucahit.usingBeansWithCamel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class InvokeWithProcessorSpringRoute extends RouteBuilder {

    @Autowired
    private HelloBean helloBean;

    @Override
    public void configure() throws Exception {
        from("direct:hello")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        String name = exchange.getIn().getBody(String.class);
                        String answer = helloBean.hello(name);
                        exchange.getIn().setBody(answer);
                    }
                });
    }
}
