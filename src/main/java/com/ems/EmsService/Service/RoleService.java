package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Role;
import com.ems.EmsService.Entity.RoleEntity;

import java.util.List;

public interface RoleService {

    public Role saveRoleDetails(Role role);

    public Role getRoleById(Long roleId);

    public List<RoleEntity> getRoleDetails();

    public Role updateRoleDetails(Long roleId, Role role);

    public String deleteRoleDetails(Long roleId);
}
