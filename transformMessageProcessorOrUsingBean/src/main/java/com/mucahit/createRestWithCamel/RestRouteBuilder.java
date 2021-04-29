package com.mucahit.createRestWithCamel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class RestRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").host("localhost").port(8080).bindingMode(RestBindingMode.auto);

        rest("/api/customers").get().route().to("direct:getCustomers");

        rest("/customers").post().route().log("The body is ${body}");

        rest("/customers").delete("{id}").to("bean:customer?method=delete(${header.id})");

        rest("/api/apartments").get("/search?country={country}").to("bean:searchBean?method=byCountry(${header.country})");

        rest().path("/my-api").get().outType(ResponseType.class).to("bean:helloBean"); // this sends the Body to the bean

        rest().post().route().inputType(Customer.class).outputType(CreateCustomerResponse.class).to("direct:post");

    }
}
