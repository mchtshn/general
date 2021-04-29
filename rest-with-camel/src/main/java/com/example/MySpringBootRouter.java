package com.example;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {

        restConfiguration().component("servlet").bindingMode(RestBindingMode.auto);

        rest().path("/go-sports").get("/").route().transform(simple("i am your resouce for all sports")).endRest()
                .post("/").type(Sport.class).route().to("log:mylogger?showAll=true").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                Sport sport = new Sport();
                SportResponse sportResponse = new SportResponse();
                sportResponse.setMessage(sport.getName());
                exchange.getIn().setBody(sportResponse);
            }
        }).endRest();
    }

}
