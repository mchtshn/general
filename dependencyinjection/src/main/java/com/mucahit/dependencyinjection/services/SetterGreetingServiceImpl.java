package com.mucahit.dependencyinjection.services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingServiceImpl implements GreetingService {
      @Override
    public String sayGreetings() {
        return "Setter greeting service";
    }
}
