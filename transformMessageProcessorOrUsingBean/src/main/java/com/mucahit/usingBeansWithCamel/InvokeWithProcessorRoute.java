package com.mucahit.usingBeansWithCamel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class InvokeWithProcessorRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:hello").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                String name = exchange.getIn().getBody(String.class);
                HelloBean helloBean = new HelloBean();
                String answer = helloBean.hello(name);
                exchange.getIn().setBody(answer);
            }
        });
    }
}
