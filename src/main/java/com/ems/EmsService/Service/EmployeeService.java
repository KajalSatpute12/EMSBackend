package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Employee;
import com.ems.EmsService.Entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

        public Employee saveEmployeeDetails(Employee emp);

        public Employee getEmployeeById(Long empId);

        public List<EmployeeEntity> getEmployeeDetails();

        public Employee updateEmployeeDetails(Long empId, Employee employee);

        public String deleteEmployeeDetails(Long empId);

}
