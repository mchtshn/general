package com.mucahit.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        //read spring config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        Coach theTennisCoach = context.getBean("tennisCoach", Coach.class);

        //call a method on the bean
        System.out.println(theTennisCoach.getDailyWorkout());

        //call a method to get daily fortune
        System.out.println(theTennisCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
