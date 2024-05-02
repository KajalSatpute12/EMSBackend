package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Employee;

public interface EmployeeService {

        public Employee saveEmployeeDetails(Employee emp);

        public Employee getEmployeeById(Long empId);

}
