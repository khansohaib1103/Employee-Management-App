package com.example.employeemanagmentapp.service;

import com.example.employeemanagmentapp.model.Employee;
import com.example.employeemanagmentapp.repository.EmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;


    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Employee> listEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable).getContent();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Employee> searchEmployees(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(employeeDetails.getName());
        employee.setAge(employeeDetails.getAge());
        employee.setEmployeeClass(employeeDetails.getEmployeeClass());
        employee.setPassword(passwordEncoder.encode(employeeDetails.getPassword()));
        employee.setSubjects(employeeDetails.getSubjects());
        employee.setAttendance(employeeDetails.getAttendance());
        employee.setRole(employeeDetails.getRole());

        return employeeRepository.save(employee);
    }
}

