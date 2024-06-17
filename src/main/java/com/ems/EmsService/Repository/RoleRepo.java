package com.ems.EmsService.Repository;

import com.ems.EmsService.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role, Long> {


}
