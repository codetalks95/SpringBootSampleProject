package com.bhushan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Employee")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer salary;
    private String managerName;
}
