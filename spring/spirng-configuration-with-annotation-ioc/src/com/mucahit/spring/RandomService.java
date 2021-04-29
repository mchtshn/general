package com.mucahit.spring;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomService implements FortuneService {
    @Override
    public String getFortune() {

        return new Random().nextInt(2)== 0 ? "Today is your lucky day!" : "Today you have a bad luck!!!!";
    }
}
