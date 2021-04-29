package com.mucahit.spring;

import org.springframework.stereotype.Component;

@Component
public class BadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "You have a bad luck!!!!";
    }
}
