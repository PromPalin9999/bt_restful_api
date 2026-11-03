package com.cybersoft.restfulapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


public class GreetingService {

    public String sayHelloAndGreeting(String name) {
        if (name.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name must not empty");
        }

        return "Hello " + name + "!";
    }

}