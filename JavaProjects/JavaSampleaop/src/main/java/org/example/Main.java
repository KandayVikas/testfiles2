package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(BeanConfig.class);

       Vehicle vehicle= context.getBean(Vehicle.class);
       vehicle.drive("30kmph");
    }
}