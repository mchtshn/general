package com.example;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {

        from("quartz://myGroup/myThirtyTimer?cron=0+0/30+*+*+*+?").routeId("thirtyMinutes")
                .transform().method("myBean", "fireThirtyMinutes")
                .to("log:foo")
                .end()
                .to("stream:out");

        from("quartz://myGroup/myFourTimer?cron=0+0+4+*+*+?").routeId("Four")
                .bean("myBean", "fireAtFour")
                .to("log:foo")
                .end()
                .to("stream:out");
    }

}
