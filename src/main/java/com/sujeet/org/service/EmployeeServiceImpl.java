package com.sujeet.org.service;

import com.sujeet.org.model.Employee;
import com.sujeet.org.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee,Long employeeId) {

        Employee empDB = employeeRepository.findById(employeeId).get();
        if(Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName()))
        {
            empDB.setName(employee.getName());
        }

        if(Objects.nonNull(employee.getAddress()) && !"".equalsIgnoreCase(employee.getAddress()))
        {
            empDB.setAddress(employee.getAddress());
        }

        if(Objects.nonNull(employee.getState()) && !"".equalsIgnoreCase(employee.getState()))
        {
            empDB.setState(employee.getState());
        }

        if(Objects.nonNull(employee.getPinNumber()) && (employee.getPinNumber()) !=0)
        {
            empDB.setPinNumber(employee.getPinNumber());
        }

        if(Objects.nonNull(employee.getMobileNumber()) && (employee.getMobileNumber())!=0)
        {
            empDB.setMobileNumber(employee.getMobileNumber());
        }
        return employeeRepository.save(empDB);
    }
    @Override
    public Optional<Employee> getSingleEmployee(Long employeeId)
    {
       if((employeeRepository.findById(employeeId)).isPresent())
        return employeeRepository.findById(employeeId);
        else
            return null;
    }
    @Override
    public void deletEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
