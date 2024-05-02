package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Employee;
import com.ems.EmsService.Exception.ResourceNotFoundException;
import com.ems.EmsService.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
