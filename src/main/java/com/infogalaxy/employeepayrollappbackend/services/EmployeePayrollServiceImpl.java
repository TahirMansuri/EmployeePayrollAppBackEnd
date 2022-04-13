package com.infogalaxy.employeepayrollappbackend.services;

import com.infogalaxy.employeepayrollappbackend.dto.EmployeePayrollDTO;
import com.infogalaxy.employeepayrollappbackend.entity.EmployeePayrollData;
import com.infogalaxy.employeepayrollappbackend.exceptions.EmployeePayrollException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService{

    /***
     * Service method to get all employee data
     * @return employeePayrollDataList
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        employeePayrollDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Tahir",10000)));
        return employeePayrollDataList;
    }

    /***
     * Service method to get employee data by given emp id
     * @param empId
     * @return employeePayrollData
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(long empId) {
        EmployeePayrollData employeePayrollData = null;
        if(empId == 1) {
            employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO("Tahir",10000));
            return employeePayrollData;
        } else {
            throw  new EmployeePayrollException("Employee with Given ID Not Found.");
        }
    }

    /***
     * Service method to Store Emploee Data in DB
     * @param employeePayrollDTO
     * @return employeePayrollData
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        return employeePayrollData;
    }

    /***
     * Service method to Update Employee Payroll Data
     * @param employeePayrollDTO
     * @return employeePayrollData
     */
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
