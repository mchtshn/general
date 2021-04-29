package com.mucahit.transformMessageProcessorOrUsingBean;

import org.apache.camel.builder.RouteBuilder;

public class ProcessorRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("quartz2://report?cron=0+0+6+*+*+?")
                .to("http://riders.com/orders/cmd=received&date=yesterday")
                .process(new OrderToCsvProcessorUsingProcessor())
                .to("file://riders/orders?fileName=report-${header.Date}.csv");
    }
}
