package com.example.employeemanagmentapp.controller;

import com.example.employeemanagmentapp.common.Role;
import com.example.employeemanagmentapp.graphql.resolver.EmployeeMutationResolver;
import com.example.employeemanagmentapp.graphql.resolver.EmployeeQueryResolver;
import com.example.employeemanagmentapp.model.Employee;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class EmpController {

    private final EmployeeQueryResolver employeeQueryResolver;
    private final EmployeeMutationResolver employeeMutationResolver;

    @Secured("ROLE_ADMIN")
    @QueryMapping
    public List<Employee> listEmployees(@Argument int page, @Argument int size, @Argument String sort) {
        return employeeQueryResolver.listEmployees(page, size, sort);
    }

    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE"})
    @QueryMapping
    public Employee getEmployeeById(@Argument Long id) {
        return employeeQueryResolver.getEmployeeById(id);
    }

    @Secured({"ROLE_ADMIN", "ROLE_EMPLOYEE"})
    @QueryMapping
    public List<Employee> searchEmployees(@Argument String name) {
        return employeeQueryResolver.searchEmployees(name);
    }

    @PermitAll
    @MutationMapping
    public Employee addEmployee(@Argument String name,
                                @Argument int age,
                                @Argument String employeeClass,
                                @Argument String password,
                                @Argument List<String> subjects,
                                @Argument int attendance,
                                @Argument Role role) {
        return employeeMutationResolver.addEmployee(name, age, employeeClass, password, subjects, attendance, role);
    }

    //@Secured("ROLE_ADMIN")
    @MutationMapping
    public Employee updateEmployee(@Argument Long id,
                                   @Argument String name,
                                   @Argument int age,
                                   @Argument String employeeClass,
                                   @Argument String password,
                                   @Argument List<String> subjects,
                                   @Argument int attendance,
                                   @Argument Role role) {
        return employeeMutationResolver.updateEmployee(id, name, age, employeeClass, password, subjects, attendance, role);
    }

}
