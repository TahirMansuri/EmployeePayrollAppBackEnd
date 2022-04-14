package com.infogalaxy.employeepayrollappbackend.exceptions;

/***
 * Custom Exception Class for Handling User Defined Exceptions
 */
public class EmployeePayrollException extends RuntimeException{
    public EmployeePayrollException(String message) {
        super(message);
    }
}
