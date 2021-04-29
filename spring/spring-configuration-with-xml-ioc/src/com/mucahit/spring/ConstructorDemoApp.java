package com.mucahit.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//app should be configurable  +
//easily change the coach for another sport +
//spring provides an object factory so our application talk to spring ,say hey give me an object based on a configuration file or annotation,spring will give appropriate implementation
public class ConstructorDemoApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from config file
        Coach theTrackCoach = context.getBean("myTrackCoach", Coach.class);
        Coach theBaseballCoach = context.getBean("myBaseballCoach", Coach.class);
        Coach theCricketCoach = context.getBean("myCricketCoach", Coach.class);

        //call methods on the bean
        System.out.println(theTrackCoach.getDailyWorkout());
        System.out.println(theTrackCoach.getDailyFortune());
        System.out.println(theBaseballCoach.getDailyWorkout());
        System.out.println(theBaseballCoach.getDailyFortune());
        System.out.println(theCricketCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
