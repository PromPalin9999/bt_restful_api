package com.cybersoft.restfulapi.service;


import com.cybersoft.restfulapi.dto.request.StudentRequestDTO;
import com.cybersoft.restfulapi.dto.response.StudentResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {

    private final Map<Long, StudentResponseDTO> student = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong();

    public StudentService() {
        add("Liaz", "A4", 15);
        add("Liems", "A1", 15);
    }

    public void add(String stuName, String stuClass, int age) {
        StudentResponseDTO stu = new StudentResponseDTO();

        stu.setId(idGen.incrementAndGet());
        stu.setStuName(stuName);
        stu.setStuClass(stuClass);
        stu.setAge(age);
        student.put(stu.getId(), stu);
    }

    public StudentResponseDTO findStuById(Long id) {
        StudentResponseDTO stu = student.get(id);
        if (stu == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can not find this student with id: " + id);
        return stu;
    }

    public StudentResponseDTO createStu(StudentRequestDTO stuReq) {
        StudentResponseDTO stu = new StudentResponseDTO();
        stu.setId(idGen.incrementAndGet());
        stu.setStuName(stuReq.getStuName());
        stu.setStuClass(stuReq.getStuClass());
        stu.setAge(stuReq.getAge());
        student.put(stu.getId(), stu);
        return stu;
    }
}
