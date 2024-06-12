package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Role;

import java.util.List;

public interface RoleService {

    public Role saveRoleDetails(Role role);

    public Role getRoleById(Long roleId);

    public List<Role> getRoleDetails();

    public Role updateRoleDetails(Long roleId, Role role);

    public String deleteRoleDetails(Long roleId);
}
