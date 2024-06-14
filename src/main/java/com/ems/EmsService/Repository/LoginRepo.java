package com.ems.EmsService.Repository;

import com.ems.EmsService.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login, String> {
}
