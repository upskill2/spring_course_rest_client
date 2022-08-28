package com.spring.rest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {

    private int id;

    private String empName;

    private String surname;

    private String department;

    private int salary;

    public Employee(String empName, String surname, String department, int salary) {
        this.empName = empName;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

}
