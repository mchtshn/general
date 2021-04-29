package com.mucahit.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//app should be configurable  +
//easily change the coach for another sport +
//spring provides an object factory so our application talk to spring ,say hey give me an object based on a configuration file or annotation,spring will give appropriate implementation
public class BeanScopeDemoApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //retrieve baseball coach  bean from config file    default scope is singleton
        Coach theBaseballCoach = context.getBean("myBaseballCoach", Coach.class);
        Coach theAlphaBaseballCoach = context.getBean("myBaseballCoach", Coach.class);

        //retrieve bean from config file    default scope is singleton
        Coach theTrackCoach = context.getBean("myTrackCoach", Coach.class);
        Coach theAlphaTrackCoach = context.getBean("myTrackCoach", Coach.class);

        //check if they are the same
        boolean baseballResult = (theBaseballCoach == theAlphaBaseballCoach);
        boolean trackResult = (theTrackCoach == theAlphaTrackCoach);

        //print out the result -- singleton scope
        System.out.println("\nPointing to the same object :: "+baseballResult);
        System.out.println("\nMemory location for theCoach :: "+theBaseballCoach);
        System.out.println("\nMemory location for theAlphaCoach :: "+theAlphaBaseballCoach);

        System.out.println("\n**************************************************************************");

        //print out the result --prototype scope   new object for new request
        System.out.println("\nPointing to the same object :: "+trackResult);
        System.out.println("\nMemory location for theCoach :: "+theTrackCoach);
        System.out.println("\nMemory location for theAlphaCoach :: "+theAlphaTrackCoach);
        //close the context
        context.close();
    }
}
