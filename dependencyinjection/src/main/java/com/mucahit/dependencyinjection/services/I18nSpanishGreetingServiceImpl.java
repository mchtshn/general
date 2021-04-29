package com.mucahit.dependencyinjection.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service("i18nService")
@Profile({"ES","default"})
public class I18nSpanishGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreetings() {
        return "Hola Mundo -- ES";
    }
}
