package com.infogalaxy.employeepayrollappbackend.repository;

import com.infogalaxy.employeepayrollappbackend.entity.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Long> {

}
