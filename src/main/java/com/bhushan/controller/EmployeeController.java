package com.bhushan.controller;

import com.bhushan.entity.EmployeeEntity;
import com.bhushan.response.EmployeeResponse;
import com.bhushan.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("saveData")
    public EmployeeResponse save(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveEmployee(employeeEntity);
    }

    @PatchMapping("partialUpdate/{id}")
    public EmployeeResponse updatePatchData(@PathVariable Integer id, @RequestBody Map<String, Object> employeeEntity) {
        return employeeService.patchUpdate(id, employeeEntity);

    }
}
