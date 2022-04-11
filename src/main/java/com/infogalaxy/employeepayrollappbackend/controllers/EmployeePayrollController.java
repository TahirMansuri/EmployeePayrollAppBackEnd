package com.infogalaxy.employeepayrollappbackend.controllers;

import com.infogalaxy.employeepayrollappbackend.dto.EmployeePayrollDTO;
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
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("Get Call Success for ID : "+empId,HttpStatus.OK);
    }

    /***
     * This service get the Employee Data in Request Body and Store it to DB
     *
     * @param employeePayrollDTO
     * @return ResponseEntity String
     */
    @PostMapping("/create")
    public ResponseEntity<String> addEmplloyeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return new ResponseEntity<String>("Created Employee Payroll Data for : "+employeePayrollDTO,HttpStatus.OK);
    }

    /***
     * This service Update the Employee Payroll Data
     *
     * @param employeePayrollDTO
     * @return ResponseEntity String
     */
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return new ResponseEntity<String>("Updated Employee Payroll Data for : "+employeePayrollDTO,HttpStatus.OK);
    }

    /***
     *
     * @param empId
     * @return ResponseEntity
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("Deleted Employee Payroll Data for : "+ empId,HttpStatus.OK);
    }
}
