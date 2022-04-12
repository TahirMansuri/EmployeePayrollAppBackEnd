package com.infogalaxy.employeepayrollappbackend.controllers;

import com.infogalaxy.employeepayrollappbackend.dto.EmployeePayrollDTO;
import com.infogalaxy.employeepayrollappbackend.dto.ResponseDTO;
import com.infogalaxy.employeepayrollappbackend.entity.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    /***
     *
     * @return Reponse Entity with HttpStatus Code
     */
    @RequestMapping(value={"","/","get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
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
        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Tahir",1000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID Successful",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     * This service get the Employee Data in Request Body and Store it to DB
     *
     * @param employeePayrollDTO
     * @return ResponseEntity String
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Call for ID Successful", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     * This service Update the Employee Payroll Data
     *
     * @param employeePayrollDTO
     * @return ResponseEntity String
     */
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1,employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update Call for Employee ID Successful",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    /***
     *
     * @param empId
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId,new EmployeePayrollDTO());
        ResponseDTO responseDTO = new ResponseDTO("Delete Call for Emp ID is Successful",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}