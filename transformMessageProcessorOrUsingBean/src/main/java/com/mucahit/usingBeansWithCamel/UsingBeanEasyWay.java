package com.mucahit.usingBeansWithCamel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class UsingBeanEasyWay extends RouteBuilder {

    @Autowired
    private HelloBean helloBean;

    @Override
    public void configure() throws Exception {
        from("direct:hello").bean(helloBean, "hello");
    }
}
