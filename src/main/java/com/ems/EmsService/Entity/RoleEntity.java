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
public class RoleEntity {

    private Long id;

    private String title;

    private String salary;

    private String department;
}
