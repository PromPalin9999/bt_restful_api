package com.cybersoft.restfulapi.service;

import com.cybersoft.restfulapi.dto.response.EmployeeResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final Map<Long, EmployeeResponseDTO> empls = new LinkedHashMap<>();

    public EmployeeService() {
        add(1L, "James Carter", "CEO", 52, "0901000001");
        add(2L, "Emily Johnson", "CTO", 45, "0901000002");
        add(3L, "Michael Brown", "HR Manager", 41, "0901000003");
        add(4L, "Sophia Davis", "Accountant", 34, "0901000004");
        add(5L, "Daniel Wilson", "Senior Backend Developer", 31, "0901000005");
        add(6L, "Olivia Martinez", "Frontend Developer", 27, "0901000006");
        add(7L, "William Anderson", "QA Engineer", 29, "0901000007");
        add(8L, "Isabella Thomas", "UI/UX Designer", 26, "0901000008");
        add(9L, "Benjamin Lee", "DevOps Engineer", 33, "0901000009");
        add(10L, "Charlotte Walker", "Marketing Specialist", 28, "0901000010");
    }

    public void add(Long id, String name, String position, int age, String phoneNum) {
        EmployeeResponseDTO empl = new EmployeeResponseDTO();

        empl.setId(id);
        empl.setName(name);
        empl.setPosition(position);
        empl.setAge(age);
        empl.setPhoneNum(phoneNum);
        empls.put(id, empl);
    }

    public EmployeeResponseDTO findEplById(Long id) {
        EmployeeResponseDTO eById = empls.get(id);
        if (eById == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return eById;
    }


}
