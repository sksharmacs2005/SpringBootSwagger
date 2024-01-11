package com.sujeet.org.controller;

import com.sujeet.org.model.Employee;
import com.sujeet.org.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
@Api(value = "Employee Resource REST Endpoint", description = "Shows the employee info")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @ApiOperation("This is used to add the Employee Details")
    @PostMapping(value = "/employeeDetails", consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity<Employee> createData(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }

    @GetMapping("/allEmp")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<Optional<Employee>> getSingleEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.getSingleEmployee(employeeId));
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employee, @PathVariable("id") Long employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee, employeeId));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") Long empId) {
        employeeService.deletEmployee(empId);
        return ResponseEntity.ok("Employee Delete Successfully!!");
    }
}