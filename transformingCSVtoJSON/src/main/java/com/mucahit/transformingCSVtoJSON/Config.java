package com.mucahit.transformingCSVtoJSON;

import org.apache.camel.model.dataformat.CsvDataFormat;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean("csvDataFormatter")
    public CsvDataFormat csvDataFormat() {
        CsvDataFormat csvDataFormat = new CsvDataFormat();
        csvDataFormat.setUseMaps(Boolean.toString(true));
        return csvDataFormat;
    }

    @Bean("jsonDataFormatter")
    public JsonDataFormat jsonDataFormat() {
        return new JsonDataFormat(JsonLibrary.Jackson);
    }
}
