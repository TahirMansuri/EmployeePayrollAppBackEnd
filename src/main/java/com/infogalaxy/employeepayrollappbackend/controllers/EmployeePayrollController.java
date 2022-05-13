package com.infogalaxy.employeepayrollappbackend.controllers;

import com.infogalaxy.employeepayrollappbackend.dto.EmployeePayrollDTO;
import com.infogalaxy.employeepayrollappbackend.dto.ResponseDTO;
import com.infogalaxy.employeepayrollappbackend.entity.EmployeePayrollData;
import com.infogalaxy.employeepayrollappbackend.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollService employeePayrollService;

    /***
     *
     * @return Reponse Entity with HttpStatus Code
     */
//    @RequestMapping(value={"","/","/get"})
//    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
//        List<EmployeePayrollData> employeePayrollDataList = null;
//        employeePayrollDataList = employeePayrollService.getEmployeePayrollData();
//        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID Successful",employeePayrollDataList);
//        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
//    }
    @RequestMapping(value={"","/","/get"})
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID Successful",employeePayrollDataList);
        //return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        return employeePayrollDataList;
    }

    /***
     * This Service get the Employee ID and Return the Message with Confirmation
     *
     * @param empId
     * @return Response Entity with HttpStatus Code
     */
    @GetMapping(value={"/get/{empId}"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID Successful",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     * This service get the Employee Data in Request Body and Store it to DB
     *
     * @param employeePayrollDTO
     * @return ResponseEntity String
     */
//    @PostMapping("/create")
//    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
//        EmployeePayrollData employeePayrollData = null;
//        employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
//        ResponseDTO responseDTO = new ResponseDTO("Create Call for ID Successful", employeePayrollData);
//        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
//    }

    @PostMapping("/create")
    public String addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Call for ID Successful", employeePayrollData);
        //return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        return "Employee Added";
    }

    /***
     * This service Update the Employee Payroll Data
     *
     * @param employeePayrollDTO
     * @return ResponseEntity String
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") long empId,@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId,employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Call for Employee ID Successful",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     *
     * @param empId
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        return new ResponseEntity<String>("Delete Call for Emp ID is Success",HttpStatus.OK);
    }

    /***
     * Method to get Employee List by Department (Custom Query defined in repository interface)
     * @param department
     * @return
     */
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmpByDepartment(@PathVariable("department") String department) {
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = employeePayrollService.findEmployeePayrollDataByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Call for Get Department Success",employeePayrollDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}