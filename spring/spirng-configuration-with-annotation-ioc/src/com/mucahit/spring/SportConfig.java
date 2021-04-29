package com.mucahit.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// basically we will tell Spring , hey this is a java configuration  follow the appropriate rules or directions here in this configuratipn file
@Configuration
@ComponentScan("com.mucahit.spring")
public class SportConfig {


    //define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService(){
        return  new SadFortuneService();
    }

    //define bean for our swim coach and inject dependency
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }


}
