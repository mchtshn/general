package com.mucahit.cameltest;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start").setBody(constant("Jupiter")).to("mock:end");
    }
}
