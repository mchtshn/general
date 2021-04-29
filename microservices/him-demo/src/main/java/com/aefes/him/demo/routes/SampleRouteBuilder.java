package com.aefes.him.demo.routes;

import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.aefes.him.demo.config.ConfigAuthorization;
import com.aefes.him.demo.env.ConfModule;
import com.aefes.him.demo.model.SampleRequestDto;
import com.aefes.him.demo.model.SampleResponseDto;
import com.aefes.him.demo.processor.SampleRequestProcessor;
import com.aefes.him.demo.processor.SampleResponseProcessor;

import com.aefes.lib.cdm.constant.INTEGRATION;
import com.aefes.lib.cdm.util.HimRestRouteBuilder;
import com.aefes.lib.cdm.util.HimRestRouteDto;
import com.aefes.lib.utility.log.MsLogger;
import com.aefes.lib.utility.log.MsLoggerFactory;

@Component
public class SampleRouteBuilder extends HimRestRouteBuilder {

    private static final MsLogger logger = MsLoggerFactory.getLogger(SampleRouteBuilder.class);

    public static final String ROUTE_ID = "DemoRoute";

    @Autowired
    @Qualifier("demoConfModule")
    private ConfModule confModule;

    @Autowired
    @Qualifier("sampleResponseFormatter")
    private JacksonDataFormat sampleResponseFormatter;

    @Autowired private SampleRequestProcessor sampleRequestProcessor;

    @Autowired private SampleResponseProcessor sampleResponseProcessor;

    @Autowired
    @Qualifier("demoAuthorization")
    private ConfigAuthorization configAuthorization;

    @Override
    public HimRestRouteDto routeDto() {
        return HimRestRouteDto.builder()
                .routeClass(getClass())
                .logger(logger.getSlf4jLogger())
                .integration(INTEGRATION.SAMPLE)
                .routeId(ROUTE_ID)
                .authorizationBean(configAuthorization)
                .authorizationMethod("hasDemoRole()")
                .rootPath("/demo/")
                .uritPath("/sample")
                .reuqestType(SampleRequestDto.class)
                .responseType(SampleResponseDto.class)
                .responseFormatter(sampleResponseFormatter)
                .isActiveConfigValue(confModule.moduleIsActive())
                .build();
    }

    @Override
    protected void configureIntegration() {
        from(epId("direct:buildRequest"))
                .process(sampleRequestProcessor)
                .log("request converted for SAP")
                .to(epId("direct:sendRequest"));

        from(epId("direct:sendRequest")).to(epId("direct:buildResponse"));

        from(epId("direct:buildResponse"))
                .process(sampleResponseProcessor)
                .log("response is ready for sample")
                .to(epId("direct:responsePostProcessor"));
    }
}
