package com.mucahit.transformMessageProcessorOrUsingBean;

import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransformMessageProcessorOrUsingBeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransformMessageProcessorOrUsingBeanApplication.class, args);
    }


    //bean ve process arasındaki fark bean de hiç camel import u kulanmazsın.Senin bean tamemen camel api dan bağımsızdır.Metodlarda yapılan işleri cmel otomatik olarak bağlar.
    //bean deki diğer fark metod ismini istediğin gibi yazabilirsin.Process kullandığında process metodunu kullnmak zorundasın.
    //bean in diğer avantajı unit test yapmak çok daha kolaydır.

}
