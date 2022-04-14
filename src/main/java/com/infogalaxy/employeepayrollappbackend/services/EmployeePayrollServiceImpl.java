package com.infogalaxy.employeepayrollappbackend.services;

import com.infogalaxy.employeepayrollappbackend.dto.EmployeePayrollDTO;
import com.infogalaxy.employeepayrollappbackend.entity.EmployeePayrollData;
import com.infogalaxy.employeepayrollappbackend.exceptions.EmployeePayrollException;
import com.infogalaxy.employeepayrollappbackend.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollServiceImpl implements IEmployeePayrollService{

    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    /***
     * Service method to get all employee data
     * @return employeePayrollDataList
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    /***
     * Service method to get employee data by given emp id
     * @param empId
     * @return employeePayrollData
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(long empId) {
        return employeePayrollRepository
                .findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with given ID not Found"));
    }

    /***
     * Service method to Store Emploee Data in DB
     * @param employeePayrollDTO
     * @return employeePayrollData
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
        log.info("Employee Data Saved");
        return employeePayrollRepository.save(employeePayrollData);
    }

    /***
     * Service method to Update Employee Payroll Data
     * @param employeePayrollDTO
     * @return employeePayrollData
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(long empId,EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.updateEmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    /***
     * Service method to Delete Employee by Id
     * @param empId
     */
    @Override
    public void deleteEmployeePayrollData(long empId) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(employeePayrollData);
    }

    /***
     * Service method to get employee data by department using custom query defined in repository interface
     * @param department
     * @return
     */
    @Override
    public List<EmployeePayrollData> findEmployeePayrollDataByDepartment(String department) {
        return employeePayrollRepository.findEmployeePayrollDataByDepartment(department);
    }


}
