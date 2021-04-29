package com.mucahit.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

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
