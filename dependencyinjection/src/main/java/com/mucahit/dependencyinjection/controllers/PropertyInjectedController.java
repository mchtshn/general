package com.mucahit.dependencyinjection.controllers;

import com.mucahit.dependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired
    @Qualifier("propertyGreetingServiceImpl")
    public GreetingService greetingService;

    public String getGreetings() {
        return greetingService.sayGreetings();
    }
}
