package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Employee;
import com.ems.EmsService.Exception.ResourceNotFoundException;
import com.ems.EmsService.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo repo;

    @Override
    public Employee saveEmployeeDetails(Employee emp){

        Employee response = new Employee();
        response = repo.save(emp);

        return response;
    }

    @Override
    public Employee getEmployeeById(Long empId) {

        Employee response = new Employee();

        response = repo.findById(empId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee details does not exist with given id: "+ empId));

        return response;
    }

    @Override
    public List<Employee> getEmployeeDetails() {

        return repo.findAll();
    }

    @Override
    public Employee updateEmployeeDetails(Long employeeId, Employee employee) {

        Employee emp = repo.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee details does not exist with given id: "+ employeeId)
        );

        emp.setEmail_id(employee.getEmail_id());
        emp.setId(employee.getId());
        emp.setFirst_name(employee.getFirst_name());
        emp.setLast_name(employee.getLast_name());
        emp.setManager_id(employee.getManager_id());
        emp.setRole_id(employee.getRole_id());

        return repo.save(emp);

    }

    @Override
    public String deleteEmployeeDetails(Long empId) {

        Employee emp = repo.findById(empId).orElseThrow(
                () -> new ResourceNotFoundException("Employee details does not exist with given id: "+ empId)
        );

        repo.delete(emp);

        return "Employee details deleted successFully";
    }
}