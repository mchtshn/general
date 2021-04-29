package com.mucahit.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//app should be configurable  +
//easily change the coach for another sport +
//spring provides an object factory so our application talk to spring ,say hey give me an object based on a configuration file or annotation,spring will give appropriate implementation
public class SetterDemoApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from config file
        CricketCoach theCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        //call methods on the bean
        System.out.println(theCricketCoach.getDailyFortune());
        System.out.println(theCricketCoach.getDailyWorkout());

        //call our literal values
        System.out.println(theCricketCoach.getEmailAddress());
        System.out.println(theCricketCoach.getTeam());

        //close the context
        context.close();
    }
}
