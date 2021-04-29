package com.mucahit.transformMessageProcessorOrUsingBean;

import org.apache.camel.builder.RouteBuilder;

public class BeanRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("quartz2://report?cron=0+0+6+*+*+?")
                .to("http://riders.com/orders/cmd=received&date=yesterday")
                .bean(new OrderToCsvBean())
                .to("file://riders/orders?fileName=report-${header.Date}.csv");
    }
}
