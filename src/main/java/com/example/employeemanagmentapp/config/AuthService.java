package com.example.employeemanagmentapp.config;

import com.example.employeemanagmentapp.model.Employee;
import com.example.employeemanagmentapp.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final EmployeeRepository empRepo;

    public AuthService(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user = empRepo.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found!"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .roles(String.valueOf(user.getRole()))
                .build();
    }

}
