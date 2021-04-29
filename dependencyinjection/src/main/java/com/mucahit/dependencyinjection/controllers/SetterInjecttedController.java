package com.mucahit.dependencyinjection.controllers;

import com.mucahit.dependencyinjection.services.GreetingService;
import com.mucahit.dependencyinjection.services.SetterGreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjecttedController {

    private GreetingService greetingService;

    public String getGreetings() {
        return greetingService.sayGreetings();
    }

    @Autowired
    public void setGreetingService(@Qualifier("setterGreetingServiceImpl") GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
