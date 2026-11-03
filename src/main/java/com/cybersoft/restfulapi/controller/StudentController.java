package com.cybersoft.restfulapi.controller;


import com.cybersoft.restfulapi.dto.request.StudentRequestDTO;
import com.cybersoft.restfulapi.dto.response.StudentResponseDTO;
import com.cybersoft.restfulapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStu(@Valid @RequestBody StudentRequestDTO stuReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStu(stuReq));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> findStuById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStuById(id));
    }

}
