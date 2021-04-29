package com.mucahit.choiceAndWhen;

import org.apache.camel.builder.RouteBuilder;

public class ChoiceRoutebuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:here")
                .choice()
                .when(body().contains("Hello world")).to("firstEndpoint")
                .when(simple("${body}=='Disco'")).to("secondEndpoint")
                .when(header("CamelFileName").isEqualTo("disco.txt")).to("secondEndpoint")
                .when(header("country").isEqualTo("GB")).to("secondEndpoint")
                .when(header("CamelFileName").endsWith(".xml")).to("endpoint")
                .when(header("country").regex("US | FR | DE")).to("endpoint")
                .otherwise()
                .to("thirdEndpoint");

    }

  /*         Example predicate                                      	What it does
            .when(body().contains("Hello, world!"))	                    When the Body of the message contains the string "Hello, world!"
            .when().simple("${body} == 'Disco'")	                    Using the Simple language to test when the Body of the message is exactly "Disco"
            .when(header("country").isEqualTo("GB"))	                When a Header with the name country equals "GB"
            .when(header("CamelFileName").isEqualTo("disco.txt"))	    Using the File component, check that the name of the received file is disco.txt
            .when(header("CamelFileName").endsWith(".xml"))         	Using the File component, using PredicateBuilder.endsWith() to check that the name of the file received ends with .xml
            .when(header("country").regex("US | FR | DE"))          	Using Camel’s regex method, check that the value of the Header with the name country is one of US, FR or DE.
            .when(xpath("/customer/@status = 'gold'"))	                            Using Camel’s XPath support, check that the value of the status attribute on the customer element is equal to gold
*/

}
