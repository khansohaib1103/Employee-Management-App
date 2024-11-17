package com.example.employeemanagmentapp.model;

import com.example.employeemanagmentapp.common.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String employeeClass;
    private String password;
    @ElementCollection
    private List<String> subjects;
    private int attendance;
    @Enumerated(EnumType.STRING)
    private Role role;
}