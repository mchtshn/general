package com.mucahit.dependencyinjection.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PrimaryGreetingServieImpl implements GreetingService {
    @Override
    public String sayGreetings() {
        return "Primary  greeting service";
    }
}
