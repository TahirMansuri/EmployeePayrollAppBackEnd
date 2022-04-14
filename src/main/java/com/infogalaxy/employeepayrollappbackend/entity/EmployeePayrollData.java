package com.infogalaxy.employeepayrollappbackend.entity;

import com.infogalaxy.employeepayrollappbackend.dto.EmployeePayrollDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="EmployeePayrollData")
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="emp_id")
    private long id;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String profilePic;
    private String note;

    @ElementCollection
    @CollectionTable(name="employee_department", joinColumns = @JoinColumn(name = "id"))
    private List<String> department;


    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.profilePic = employeePayrollDTO.profilePic;
        this.note = employeePayrollDTO.note;
        this.department = employeePayrollDTO.department;
    }

    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.profilePic = employeePayrollDTO.profilePic;
        this.note = employeePayrollDTO.note;
        this.department = employeePayrollDTO.department;
    }
}
