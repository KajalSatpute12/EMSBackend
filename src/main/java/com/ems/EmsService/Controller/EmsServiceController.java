package com.ems.EmsService.Controller;

import com.ems.EmsService.Entity.*;
import com.ems.EmsService.Service.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ems/")
public class EmsServiceController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService deptService;

    @Autowired
    RoleService roleService;

    @Autowired
    LoginService loginService;

    @Autowired
    ManagerDetails managerDetails;

    // Save employee Details
    @Operation(tags="Save Methods")
    @PostMapping(path = "/saveEmployeeDetails")
    public ResponseEntity<Employee> saveEmployeeDetails(
            @RequestBody Employee emp){
       Employee employee = employeeService.saveEmployeeDetails(emp);
       return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    // Get employee Details by Id
    @Operation(tags="Get Methods")
    @GetMapping(path = "/getEmployeeById")
    public ResponseEntity<Employee> getEmployeeById( Long id){

        Employee emp = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    // Get all employee Details
    @Operation(tags="Get Methods")
    @GetMapping(path = "/getEmployeeDetails")
    public ResponseEntity<List<Employee>> getEmployeeDetails(){

        List<Employee> response = employeeService.getEmployeeDetails();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Update Employee Details
    @Operation(tags="Update Methods")
    @PutMapping(path = "/updateEmployeeDetails")
    public ResponseEntity<Employee> updateEmployeeDetails(
            @RequestBody Employee employee,
            Long id
    ){
        Employee response = employeeService.updateEmployeeDetails(id, employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(tags="Delete Methods")
    @DeleteMapping(path = "/deleteEmployeeDetails")
    public ResponseEntity<String> deleteEmployeeDetails(Long id){
        return new ResponseEntity<>(employeeService.deleteEmployeeDetails(id), HttpStatus.OK);
    }

    // Save Department Details
    @Operation(tags="Save Methods")
    @PostMapping(path = "/saveDepartmentDetails")
    public ResponseEntity<Department> saveDepartmentDetails(
            @RequestBody Department dept){
        Department Department = deptService.saveDepartmentDetails(dept);
        return new ResponseEntity<>(Department, HttpStatus.CREATED);
    }

    // Get Department Details by Id
    @Operation(tags="Get Methods")
    @GetMapping(path = "/getDepartmentById")
    public ResponseEntity<Department> getDepartmentById( Long id){

        Department dept = deptService.getDepartmentById(id);
        return new ResponseEntity<>(dept, HttpStatus.OK);
    }

    // Get all Department Details
    @Operation(tags="Get Methods")
    @GetMapping(path = "/getDepartmentDetails")
    public ResponseEntity<List<Department>> getDepartmentDetails(){

        List<Department> response = deptService.getDepartmentDetails();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Update Department Details
    @Operation(tags="Update Methods")
    @PutMapping(path = "/updateDepartmentDetails")
    public ResponseEntity<Department> updateDepartmentDetails(
            @RequestBody Department Department,
            Long id
    ){
        Department response = deptService.updateDepartmentDetails(id, Department);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(tags="Delete Methods")
    @DeleteMapping(path = "/deleteDepartmentDetails")
    public ResponseEntity<String> deleteDepartmentDetails(Long id){
        return new ResponseEntity<>(deptService.deleteDepartmentDetails(id), HttpStatus.OK);
    }

    // Save Role Details
    @Operation(tags="Save Methods")
    @PostMapping(path = "/saveRoleDetails")
    public ResponseEntity<Role> saveRoleDetails(
            @RequestBody Role role){
        Role Role = roleService.saveRoleDetails(role);
        return new ResponseEntity<>(Role, HttpStatus.CREATED);
    }

    // Get Role Details by Id
    @Operation(tags="Get Methods")
    @GetMapping(path = "/getRoleById")
    public ResponseEntity<Role> getRoleById( Long id){

        Role role = roleService.getRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    // Get all Role Details
    @Operation(tags="Get Methods")
    @GetMapping(path = "/getRoleDetails")
    public ResponseEntity<List<Role>> getRoleDetails(){

        List<Role> response = roleService.getRoleDetails();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Update Role Details
    @Operation(tags="Update Methods")
    @PutMapping(path = "/updateRoleDetails")
    public ResponseEntity<Role> updateRoleDetails(
            @RequestBody Role Role,
            Long id
    ){
        Role response = roleService.updateRoleDetails(id, Role);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(tags="Delete Methods")
    @DeleteMapping(path = "/deleteRoleDetails")
    public ResponseEntity<String> deleteRoleDetails(Long id){
        return new ResponseEntity<>(roleService.deleteRoleDetails(id), HttpStatus.OK);
    }

    @Operation(tags="Get Methods")
    @GetMapping(path = "/getLoginDetails")
    public ResponseEntity<List<Login>> loginDetails(){
        return new ResponseEntity<>(loginService.getLoginDetails(), HttpStatus.OK);
    }

    @Operation(tags="Get Methods")
    @GetMapping(path = "/getManagerDetails")
    public ResponseEntity<List<Manager>> managerDetails(){
        return new ResponseEntity<>(managerDetails.getManagerDetails(), HttpStatus.OK);
    }
}
