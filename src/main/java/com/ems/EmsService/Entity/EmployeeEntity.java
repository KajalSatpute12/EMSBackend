package com.ems.EmsService.Entity;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    private Long id;

    private String name;

    private String email_id;

    private String role;

    private String manager;
}
