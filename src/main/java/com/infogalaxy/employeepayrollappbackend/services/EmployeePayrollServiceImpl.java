package com.infogalaxy.employeepayrollappbackend.services;

import com.infogalaxy.employeepayrollappbackend.dto.EmployeePayrollDTO;
import com.infogalaxy.employeepayrollappbackend.entity.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService{

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        employeePayrollDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Tahir",10000)));
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(long empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO("Tahir",10000));
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(long empId) {

    }
}
