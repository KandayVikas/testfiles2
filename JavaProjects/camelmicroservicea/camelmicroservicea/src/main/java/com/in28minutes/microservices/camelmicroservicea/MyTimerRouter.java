package com.in28minutes.microservices.camelmicroservicea;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyTimerRouter extends RouteBuilder {

    @Autowired
    private simpletimer simpletimer;
    @Override
    public void configure() throws Exception {

        from("timer:mytimer")
                .log("${body}")
                .transform().constant("My constant message")
                .log("${body}")
                .bean(simpletimer)
                .to("log:mytimer");
    }

    class simpletimer{
          public LocalDateTime getTime(){
              return LocalDateTime.now();
          }
    }
}
