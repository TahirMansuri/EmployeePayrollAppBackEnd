package com.infogalaxy.employeepayrollappbackend.services;

import com.infogalaxy.employeepayrollappbackend.dto.EmployeePayrollDTO;
import com.infogalaxy.employeepayrollappbackend.entity.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(long empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(long empId);

}
