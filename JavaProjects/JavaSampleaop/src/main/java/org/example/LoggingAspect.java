package org.example;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

   // @Before("execution(public void drive())")
   //* means any return type
    //.. inside drive means any number of return type
   @Before("execution(* org.example.Vehicle.drive(..))")
    public void logBefore(JoinPoint jp){
       String s=jp.getArgs()[0].toString();
       System.out.println("before method "+s);
    }

    @After("execution(* *.*.drive(..))")// any return type any package any class in this method
    public void logAfter(){
        System.out.println("after method");
    }


  //  @AfterReturning(Pointcut = "execution(* org.example.Vehicle.colour())",returning = "retVal")
    public void afterReturning(String retVal){
        System.out.println("After returning value "+retVal);
    }
}
