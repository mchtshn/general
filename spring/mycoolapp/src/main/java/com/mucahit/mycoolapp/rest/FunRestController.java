package com.mucahit.mycoolapp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class FunRestController {

    //expose "/" that return hello world
    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Time on server is "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss"));
    }

    //expose "/workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    //expose "/fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!";
    }

}
