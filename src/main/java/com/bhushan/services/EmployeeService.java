package com.bhushan.services;

import com.bhushan.entity.EmployeeEntity;
import com.bhushan.repository.EmployeeRepository;
import com.bhushan.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponse saveEmployee(EmployeeEntity employeeEntity) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        EmployeeEntity employeeEntity1 = employeeRepository.save(employeeEntity);
        employeeResponse.setStatus(200);
        employeeResponse.setMessage("Employee Saved Successfully");
        employeeResponse.setEmployeeEntity(employeeEntity1);
        return employeeResponse;
    }

    public EmployeeResponse patchUpdate(Integer id, Map<String, Object> employeeEntity) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        Optional<EmployeeEntity> employeeEntity1 = employeeRepository.findById(id);
        if (employeeEntity1.isPresent()) {
            employeeEntity1.ifPresent(entity -> employeeEntity.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(EmployeeEntity.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, entity, value);

            }));
            employeeResponse.setStatus(200);
            employeeResponse.setMessage("Employee Saved Successfully");
            employeeResponse.setEmployeeEntity(employeeEntity1.get());
            return employeeResponse;
        }
        employeeResponse.setStatus(500);
        employeeResponse.setMessage("Something Went Wrong");
        employeeResponse.setEmployeeEntity(null);
        return employeeResponse;
    }
}
