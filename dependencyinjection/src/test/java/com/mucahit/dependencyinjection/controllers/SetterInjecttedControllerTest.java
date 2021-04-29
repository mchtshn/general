package com.mucahit.dependencyinjection.controllers;

import com.mucahit.dependencyinjection.services.ConstructorGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjecttedControllerTest {

    SetterInjecttedController controller;

    @BeforeEach
    void setUp(){
        controller = new SetterInjecttedController();
        controller.setGreetingService(new ConstructorGreetingServiceImpl());
    }

    @Test
    void getGreetings() {
        System.out.println(controller.getGreetings());
    }
}