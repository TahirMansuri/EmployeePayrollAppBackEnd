package com.infogalaxy.employeepayrollappbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {
    /***
     * Appllying Validation using Hibernet Validator for Emp Name
     * if this Validation fails then CUSTOM EXCEPTION HANDLER will handle it
     */
    @NotEmpty(message= "Employee Name can not be empty.")
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z\\s]{2,}$", message = "Employee Name must start with Capital Letter and Contain atleast 3 Char")
    public String name;

    /***
     * Appllying Validation using Hibernet Validator for Emp Salary
     */
    @Min(value = 5000, message = "Salary must be more than 5000")
    public long salary;
}
