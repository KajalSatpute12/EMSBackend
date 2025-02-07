package com.ems.EmsService.Repository;

import com.ems.EmsService.Entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<Register, String> {

}
