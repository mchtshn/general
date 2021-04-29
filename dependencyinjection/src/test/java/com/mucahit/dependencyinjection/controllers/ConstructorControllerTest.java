package com.mucahit.dependencyinjection.controllers;

import com.mucahit.dependencyinjection.services.ConstructorGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorControllerTest {

    ConstructorController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorController(new ConstructorGreetingServiceImpl());
    }

    @Test
    void getGreetings() {
        System.out.println(controller.getGreetings());
    }
}