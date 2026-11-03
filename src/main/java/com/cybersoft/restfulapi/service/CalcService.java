package com.cybersoft.restfulapi.service;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CalcService {
    public double calcAdd(double x, double y) {

        return x + y;
    }

    public double calcSubtract(double x, double y) {
        return x - y;
    }

    public double calcMultiply(double x, double y){
        return x * y;
    }

    public double calcDivide(double x, double y){
        if(y == 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"can not divide by 0");
        }
        return x / y;
    }
}