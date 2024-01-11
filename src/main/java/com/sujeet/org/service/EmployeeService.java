package com.sujeet.org.service;

import com.sujeet.org.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee createEmployee(Employee emp);
    List<Employee> getAllEmployee();

    Optional<Employee> getSingleEmployee(Long employeeId);
    Employee updateEmployee(Employee employee,Long employeeId);

    void deletEmployee(Long employeeId);
}
