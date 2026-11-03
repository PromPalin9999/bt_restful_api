package com.cybersoft.restfulapi.controller;


import com.cybersoft.restfulapi.service.CalcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/add")
    public ResponseEntity<Double> calcAdd(@RequestParam double x,
                                          @RequestParam double y) {
        return ResponseEntity.ok(calcService.calcAdd(x, y));
    }


    @GetMapping("/subtract")
    public ResponseEntity<Double> calcSubtract(@RequestParam double x,
                                               @RequestParam double y) {
        return ResponseEntity.ok(calcService.calcSubtract(x, y));
    }

    @GetMapping("/multiply")
    public ResponseEntity<Double> calcMultiply(@RequestParam double x,
                                               @RequestParam double y) {
        return ResponseEntity.ok(calcService.calcMultiply(x, y));
    }

    @GetMapping("/divide")
    public ResponseEntity<Double> calcDivide(@RequestParam double x,
                                             @RequestParam double y) {
        return ResponseEntity.ok(calcService.calcDivide(x, y));
    }

}
