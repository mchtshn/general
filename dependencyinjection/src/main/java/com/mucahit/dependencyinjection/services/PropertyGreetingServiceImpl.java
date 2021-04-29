package com.mucahit.dependencyinjection.services;

import org.springframework.stereotype.Service;

@Service
public class PropertyGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreetings() {
        return "Property greeting service";
    }
}
