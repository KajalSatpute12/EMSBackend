package com.ems.EmsService.Controller;

import com.ems.EmsService.Entity.Employee;
import com.ems.EmsService.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ems/")
public class EmsServiceController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(path = "/saveEmployeeDetails")
    public ResponseEntity<Employee> saveEmployeeDetails(
            @RequestBody Employee emp){
       Employee employee = employeeService.saveEmployeeDetails(emp);
       return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping(path = "/getEmployeeById")
    public ResponseEntity<Employee> getEmployeeById( Long id){

        Employee emp = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
}
