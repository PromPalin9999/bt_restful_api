package com.cybersoft.restfulapi.controller;

import com.cybersoft.restfulapi.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping
    public ResponseEntity<String> sayHelloAndGreeting(@RequestParam String name){
        return ResponseEntity.ok(greetingService.sayHelloAndGreeting(name));
    }
}
