package com.infogalaxy.employeepayrollappbackend.repository;

import com.infogalaxy.employeepayrollappbackend.entity.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Long> {

    /***
     * Custom query to get employee data by department
     * @param department
     * @return
     */
    @Query(value = "select * from employee_payroll_data, employee_department where emp_id = id and department = :department",nativeQuery = true)
    List<EmployeePayrollData> findEmployeePayrollDataByDepartment(String department);
}
