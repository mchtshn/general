package com.mucahit.transformMessageProcessorOrUsingBean;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class ProcessorRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("quartz2://report?cron=0+0+6+*+*+?")
                .to("http://riders.com/orders/cmd=received&date=yesterday")
                .process(new OrderToCsvProcessor())
                .pollEnrich("ftp://riders.com/orders/?username=rider&password=secret", new AggregationStrategy() {
                    @Override
                    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
                        if (newExchange == null)
                            return oldExchange;
                        String http = oldExchange.getIn().getBody(String.class);
                        String ftp = newExchange.getIn().getBody(String.class);

                        String body = http + "\n" + ftp;
                        oldExchange.getIn().setBody(body);

                        return oldExchange;

                    }
                })
                .to("file://riders/orders");
    }

    /*The route is triggered by Quartz to run at 6 a.m. every day. You invoke the HTTP service to retrieve the orders and transform them to CSV
    format by using a processor.At this point, you need to enrich the existing data with the orders from the remote FTP server.
     This is done by using pollEnrich ❶, which consumes the remote file.To merge the data, you use AggregationStrategy ❷.
     First, you check whether any data was consumed. If newExchange is null, there’s no remote file to consume, and you just return the existing data.
      If there’s a remote file, you merge the data by concatenating the existing data with the new data and setting it back on the oldExchange.
       Then, you return the merged data by returning the oldExchange. To write the CSV report file, you use the file component ❸.
*/
}
