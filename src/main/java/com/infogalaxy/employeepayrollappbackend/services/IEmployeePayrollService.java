package com.infogalaxy.employeepayrollappbackend.services;

import com.infogalaxy.employeepayrollappbackend.dto.EmployeePayrollDTO;
import com.infogalaxy.employeepayrollappbackend.entity.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    /***
     * Method to Get All Employee Data
     * @return
     */
    List<EmployeePayrollData> getEmployeePayrollData();

    /***
     * Method to Get Employee Data by ID
     * @param empId
     * @return
     */
    EmployeePayrollData getEmployeePayrollDataById(long empId);

    /***
     * Method to Save Employee Data
     * @param employeePayrollDTO
     * @return
     */
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    /***
     * Method to Update Employee Data
     * @param empId
     * @param employeePayrollDTO
     * @return
     */
    EmployeePayrollData updateEmployeePayrollData(long empId,EmployeePayrollDTO employeePayrollDTO);

    /***
     * Method to Delete Employee Data By ID
     * @param empId
     */
    void deleteEmployeePayrollData(long empId);

    /***
     * Custom Method for getting employee by department (also defined custome query in repository interface)
     * @param department
     * @return
     */
    List<EmployeePayrollData> findEmployeePayrollDataByDepartment(String department);
}
