package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Login;
import com.ems.EmsService.Repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepo repo;

    @Override
    public List<Login> getLoginDetails() {

        return repo.findAll();
    }
}
