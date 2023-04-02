package org.example;


import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    public void drive(String speed){
        System.out.println("driving with speed "+speed);
    }

    public String colour(){
        return "white";
    }
}
