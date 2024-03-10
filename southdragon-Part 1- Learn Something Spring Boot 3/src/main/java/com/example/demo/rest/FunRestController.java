package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
// Part 1
//    inject properties for :coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

//    expose new endpoint for " team info"
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach:"+ coachName +", Team name:" + teamName;
    }

    //expose "/" that return "Hello World"
    @GetMapping("/")
    public String getHello(){
        return "Hello world";
    }

    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Fuck you";
    }


    //expose a new endpoint for "workout"
    @GetMapping("/fuckyou")
    public String getFuck(){
        return "Fuck you five times";
    }
}
