package com.ems.EmsService.Repository;

import com.ems.EmsService.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
