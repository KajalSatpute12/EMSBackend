package com.ems.EmsService.Service;

import com.ems.EmsService.Entity.Employee;
import com.ems.EmsService.Entity.Login;
import com.ems.EmsService.Entity.Register;
import com.ems.EmsService.Repository.LoginRepo;
import com.ems.EmsService.Repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    RegisterRepo _repo;

    @Autowired
    LoginRepo _loginRepo;

//    @Autowired
//    Employee _emp;

    @Override
    public String createNewUser(Register register) {

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(register.getPassword());
        if(matcher.matches()) {
            _repo.save(register);
            Login login = new Login();
            login.setUsername(register.getUsername());
            login.setPassword(register.getPassword());
            _loginRepo.save(login);
        }
        else
            return "Invalid Password. \nPassword must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number and one special character.";
        return "Registration successful.";
    }
}
