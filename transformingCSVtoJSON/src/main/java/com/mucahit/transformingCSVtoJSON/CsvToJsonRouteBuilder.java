package com.mucahit.transformingCSVtoJSON;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CsvToJsonRouteBuilder extends RouteBuilder {

    @Autowired
    @Qualifier("csvDataFormatter")
    private CsvDataFormat csvDataFormat;

    @Autowired
    @Qualifier("jsonDataFormatter")
    private JsonDataFormat jsonDataFormat;

    @Override
    public void configure() throws Exception {
        from("file:input/csv")
                .unmarshal()
    }
}
