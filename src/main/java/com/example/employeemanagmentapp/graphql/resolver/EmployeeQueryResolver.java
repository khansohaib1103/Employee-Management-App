package com.example.employeemanagmentapp.graphql.resolver;

import com.example.employeemanagmentapp.model.Employee;
import com.example.employeemanagmentapp.service.EmployeeService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeQueryResolver implements GraphQLQueryResolver {

    private final EmployeeService employeeService;

    public EmployeeQueryResolver(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> listEmployees(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return employeeService.listEmployees(pageable);
    }

    public Employee getEmployeeById(Long id) {
        return employeeService.getEmployeeById(id);
    }

    public List<Employee> searchEmployees(String name) {
        return employeeService.searchEmployees(name);
    }
}

