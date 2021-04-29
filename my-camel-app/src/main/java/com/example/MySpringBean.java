package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("myBean")
public class MySpringBean {

    private  Map<Date, Date>  dateDateHashMap= new HashMap<>();


    @Value("${greeting}")
    private String say;

    public String fireThirtyMinutes() {
        dateDateHashMap.put(new Date(),new Date());
        return "Fire every 30 minutes every day ";
    }

    public String fireAtFour() {
        dateDateHashMap.clear();
        return "Fire at 4 am every day ";
    }

}
