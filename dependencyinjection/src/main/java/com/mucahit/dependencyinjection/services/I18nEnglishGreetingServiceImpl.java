package com.mucahit.dependencyinjection.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("i18nService")
@Profile("EN")
public class I18nEnglishGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreetings() {
        return "Hello World -- EN";
    }
}
