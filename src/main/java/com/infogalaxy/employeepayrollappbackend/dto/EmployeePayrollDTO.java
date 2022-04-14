package com.infogalaxy.employeepayrollappbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

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

    /***
     * Using Pattern for User Selection only for Male and Female Values
     */
    @Pattern(regexp = "Male|Female",message = "Gender must be Male or Female")
    public String gender;

    /***
     * Applying Date Format using @JsonFormat Validation along with @PastOrPresent check
     */
    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start Date Should not be empty")
    @PastOrPresent(message = "Start Date should be Past or Present Date")
    public LocalDate startDate;

    /***
     * Validation for Note
     */
    @NotBlank(message = "Notes should not be empty.")
    public String note;

    /***
     * @NotBlank Validation for profilePic
     */
    @NotBlank(message = "Profile Pic should not be blank.")
    public String profilePic;

    /***
     * Using List for Handling Multiple Department Values
     */
    @NotNull(message = "Department Cannot be empty.")
    public List<String> department;
}
