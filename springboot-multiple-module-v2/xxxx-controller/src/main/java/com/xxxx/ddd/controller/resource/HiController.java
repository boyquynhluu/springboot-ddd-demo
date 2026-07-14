package com.xxxx.ddd.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xxxx.ddd.application.service.event.EventAppService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/hello")
public class HiController {

    @Autowired
    private EventAppService eventAppService;
    
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hi")
    @RateLimiter(name = "backendA", fallbackMethod = "fallbackHello")
    public String hello() {
        return eventAppService.sayHi("Hi");
    }

    public String fallbackHello(Throwable throwable) {
        return "Too many request";
    }

    @GetMapping("/hi/v1")
    @RateLimiter(name = "backendB", fallbackMethod = "fallbackHello")
    public String helloV1() {
        return eventAppService.sayHi("Ho");
    }
    
    @GetMapping("/circuit/breaker")
    public String circuitBreaker() {
        return restTemplate.getForObject("https://fakestoreapi.com/products/7", String.class);
    }
}
