package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
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
