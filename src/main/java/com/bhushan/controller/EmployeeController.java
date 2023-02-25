package com.bhushan.controller;

import com.bhushan.entity.EmployeeEntity;
import com.bhushan.response.EmployeeResponse;
import com.bhushan.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("saveData")
    public EmployeeResponse saveData(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveEmployee(employeeEntity);
    }

    @PatchMapping("partialUpdate/{id}")
    public EmployeeResponse updatePatchData(@PathVariable Integer id, @RequestBody Map<String, Object> employeeEntity) {
        return employeeService.patchUpdate(id, employeeEntity);
    }
}
