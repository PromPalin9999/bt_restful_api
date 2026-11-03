package com.cybersoft.restfulapi.controller;


import com.cybersoft.restfulapi.dto.response.EmployeeResponseDTO;
import com.cybersoft.restfulapi.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEplById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findEplById(id));
    }
}
