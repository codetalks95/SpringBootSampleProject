package com.bhushan.response;

import com.bhushan.entity.EmployeeEntity;
import lombok.Data;

@Data
public class EmployeeResponse {
    private Integer status;
    private String message;
    private EmployeeEntity employeeEntity;
}
