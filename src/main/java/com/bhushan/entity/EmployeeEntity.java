package com.bhushan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer salary;
    private String managerName;
    private String employedDate;
}
