package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Department;
import com.ems.EmsService.Entity.Employee;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartmentDetails(Department dept);

    public Department getDepartmentById(Long deptId);

    public List<Department> getDepartmentDetails();

    public Department updateDepartmentDetails(Long deptId, Department dept);

    public String deleteDepartmentDetails(Long deptId);

}
