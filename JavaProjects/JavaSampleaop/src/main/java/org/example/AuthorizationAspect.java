package org.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthorizationAspect {

    @Pointcut("within(org..*)")//for all the classes within package org
    public void authenticatingPointCut(){
        System.out.println("authenticate");
    }
    @Pointcut("within(org..*)")
    public void authorizationPointCut(){
        System.out.println("authorize");
    }

    @Before("authenticatingPointCut() && authorizationPointCut()")
    public void authenticate(){
        System.out.println("Authenticating the request");
    }
}
