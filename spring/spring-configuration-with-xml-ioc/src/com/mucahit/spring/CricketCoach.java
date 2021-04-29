package com.mucahit.spring;

public class CricketCoach implements Coach {

    //add new fields
    private String emailAddress;
    private String team;


    //define a private field for the dependency
    private FortuneService fortuneService;

    public CricketCoach() {
        System.out.println("CricketCoach : inside no-arg constructor.");
    }

    //define a setter for dependency injection
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach : inside setter method - setFortuneService.");
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach : inside setter method - setEmailAddress.");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach : inside setter method - setTeam.");
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {

        //use my fortune service to get a fortune
        return fortuneService.getFortune();
    }
}
