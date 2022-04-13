package com.infogalaxy.employeepayrollappbackend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollAppBackEndApplication.class, args);
        log.info("Employee Payroll App Service Started.");
    }
}
