package com.mucahit.usingBeansWithCamel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class UseBeanVersionTwo extends RouteBuilder {

    @Autowired
    private HelloBean helloBean;

    @Override
    public void configure() throws Exception {
        from("direct:hello").to("bean:helloBean?method=hello");

    }
}
