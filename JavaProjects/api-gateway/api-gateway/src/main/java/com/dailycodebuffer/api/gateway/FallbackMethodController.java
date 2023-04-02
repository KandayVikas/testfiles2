package com.dailycodebuffer.api.gateway;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

//    @GetMapping("/userServiceFallback")
//    @TimeLimiter(name="getMessageRateLimit")
//    public String userServiceFallback(){
//       return "User Service is taking longer time than expected. Please try again later";
//    }

    @GetMapping("/departmentServiceFallback")
    @TimeLimiter(name="departmentServiceFallback")
    public String departmentServiceFallback(){
        return "Department Service is taking longer time than expected. Please try again later";
    }
}
