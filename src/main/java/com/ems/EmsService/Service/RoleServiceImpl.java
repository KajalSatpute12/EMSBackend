package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Role;
import com.ems.EmsService.Exception.ResourceNotFoundException;
import com.ems.EmsService.Repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepo repo;

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
    public List<Role> getRoleDetails() {
        return repo.findAll();
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
