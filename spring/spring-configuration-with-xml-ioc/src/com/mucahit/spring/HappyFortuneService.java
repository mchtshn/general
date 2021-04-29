package com.mucahit.spring;

import java.util.Random;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        int number = new Random().nextInt(3);
        if (number==0)
            return "Today is your lucky day.";
        else if (number==1)
            return "Today is your super lucky day.";
        else
            return "Your luck is so bad";
    }
}
