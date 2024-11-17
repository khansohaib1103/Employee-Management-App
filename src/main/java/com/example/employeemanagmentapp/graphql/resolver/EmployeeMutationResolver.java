package com.example.employeemanagmentapp.graphql.resolver;

import com.example.employeemanagmentapp.common.Role;
import com.example.employeemanagmentapp.model.Employee;
import com.example.employeemanagmentapp.service.EmployeeService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMutationResolver implements GraphQLMutationResolver {

    private final EmployeeService employeeService;
    private final PasswordEncoder passwordEncoder;

    private final Employee employee;

    public EmployeeMutationResolver(EmployeeService employeeService, PasswordEncoder passwordEncoder, Employee employee) {
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
        this.employee = employee;
    }

    public Employee addEmployee(String name, int age, String employeeClass, String password, List<String> subjects, int attendance, Role role) {
        employee.setName(name);
        employee.setAge(age);
        employee.setEmployeeClass(employeeClass);
        employee.setPassword(passwordEncoder.encode(password));
        employee.setSubjects(subjects);
        employee.setAttendance(attendance);
        employee.setRole(role);
        return employeeService.addEmployee(employee);
    }

    public Employee updateEmployee(Long id, String name, int age, String employeeClass, String password, List<String> subjects, int attendance, Role role) {
        employee.setName(name);
        employee.setAge(age);
        employee.setEmployeeClass(employeeClass);
        employee.setPassword(password);
        employee.setSubjects(subjects);
        employee.setAttendance(attendance);
        employee.setRole(role);
        return employeeService.updateEmployee(id, employee);
    }
}
