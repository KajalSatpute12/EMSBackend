package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Department;
import com.ems.EmsService.Entity.Role;
import com.ems.EmsService.Entity.RoleEntity;
import com.ems.EmsService.Exception.ResourceNotFoundException;
import com.ems.EmsService.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepo repo;

    @Autowired
    DepartmentService dept;

    @Override
    public Role saveRoleDetails(Role role) {
        return repo.save(role);
    }

    @Override
    public Role getRoleById(Long roleId) {

        Role response = new Role();

        response = repo.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role details does not exist for given id: " + roleId));

        return response;
    }

    @Override
    public List<RoleEntity> getRoleDetails() {

        List<RoleEntity> response = new ArrayList<>();
        List<Role> role = repo.findAll();

        for(Role r: role){
            RoleEntity re = new RoleEntity();
            re.setId(r.getId());
            re.setTitle(r.getTitle());
            re.setSalary(r.getSalary());
            Department d = dept.getDepartmentById(r.getDepartment_id());
            re.setDepartment(d.getName());

            response.add(re);
        }

        return response;
    }

    @Override
    public Role updateRoleDetails(Long roleId, Role role) {

        Role response = new Role();

        response = repo.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role details not found for the given id: "+ roleId));

        response.setSalary(role.getSalary());
        response.setTitle(role.getTitle());
        response.setDepartment_id(role.getDepartment_id());

        return repo.save(response);
    }

    @Override
    public String deleteRoleDetails(Long roleId) {

        Role response = new Role();

        response = repo.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role details does not exist for the given id: "+ roleId));

        repo.delete(response);

        return "Role details deleted successfully.";
    }
}
