package com.example.employeemanagmentapp.repository;

import com.example.employeemanagmentapp.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findByNameContaining(String name);
    Optional<Employee> findByName(String name);
}
