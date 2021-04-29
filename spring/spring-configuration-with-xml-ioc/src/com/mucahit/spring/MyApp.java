package com.mucahit.spring;


//app should be configurable  -
//easily change the coach for another sport +
public class MyApp {

    public static void main(String[] args) {
        //create the objects
        Coach baseballCoach = new BaseballCoach();//this is hardcoded

        Coach trackCoach = new TrackCoach();//this is hardcoded

        //use the objects
        System.out.println(baseballCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyWorkout());

    }
}
