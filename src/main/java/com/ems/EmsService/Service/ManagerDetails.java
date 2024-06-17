package com.ems.EmsService.Service;


import com.ems.EmsService.Entity.Employee;
import com.ems.EmsService.Entity.Manager;
import com.ems.EmsService.Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ManagerDetails {

    @Autowired
    EmployeeService empService;

    @Autowired
    RoleService roleService;

    public List<Manager> getManagerDetails(){

        List<Manager> response = new ArrayList<>();
        List<Employee> emp = empService.getEmployeeDetails();
        List<Role> role = roleService.getRoleDetails();

        List<Long> lst = role.stream()
                .filter(r -> r.getTitle().toLowerCase().contains("manager"))
                .map(Role::getId)
                .toList();

        for (Employee e : emp) {
            for (Long aLong : lst) {
                if (Objects.equals(aLong, e.getId())) {
                    Manager m = new Manager();
                    m.setId(e.getId());
                    m.setName(e.getFirst_name().concat(" ").concat(e.getLast_name()));
                    response.add(m);
                }
            }
        }

        return response;
    }



}
