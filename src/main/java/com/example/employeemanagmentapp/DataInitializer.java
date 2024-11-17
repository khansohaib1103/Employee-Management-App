package com.example.employeemanagmentapp;

import com.example.employeemanagmentapp.model.Employee;
import com.example.employeemanagmentapp.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.employeemanagmentapp.common.Role.ROLE_ADMIN;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (employeeRepository.findAll().isEmpty()) {
            Employee admin = new Employee();
            admin.setName("Admin");
            admin.setAge(30);
            admin.setEmployeeClass("ADMIN");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setSubjects(List.of("Management"));
            admin.setAttendance(100);
            admin.setRole(ROLE_ADMIN);
            employeeRepository.save(admin);
        }
    }
}
