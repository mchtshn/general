package com.mucahit.dependencyinjection.services;

public class ConstructorGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreetings() {
        return "Constructor greeting service";
    }
}
