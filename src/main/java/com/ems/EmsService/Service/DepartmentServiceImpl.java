package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Department;
import com.ems.EmsService.Exception.ResourceNotFoundException;
import com.ems.EmsService.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepo repo;

    @Override
    public Department saveDepartmentDetails(Department dept) {

        return repo.save(dept);
    }

    @Override
    public Department getDepartmentById(Long deptId) {

        Department dept = new Department();
        dept = repo.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("Department details does not exist with given id: "+ deptId));

        return dept;
    }

    @Override
    public List<Department> getDepartmentDetails() {
        return  repo.findAll();
    }

    @Override
    public Department updateDepartmentDetails(Long deptId, Department dept) {

        Department response = new Department();

        response = repo.findById(deptId)
                .orElseThrow(()-> new ResourceNotFoundException("Department details does not exist with given id: "+ deptId));

        response.setName(dept.getName());
        return repo.save(response);
    }

    @Override
    public String deleteDepartmentDetails(Long deptId) {

        Department response = new Department();

        response = repo.findById(deptId)
                .orElseThrow(()-> new ResourceNotFoundException("Department details does not exist with given id: "+ deptId));

        repo.deleteById(deptId);
        return "Department details deleted successfully";
    }
}
