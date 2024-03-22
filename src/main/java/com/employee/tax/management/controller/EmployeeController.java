package com.employee.tax.management.controller;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.tax.management.dto.TaxDeductionDTO;
import com.employee.tax.management.entity.Employee;
import com.employee.tax.management.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
   
    @GetMapping("/tax-deductions")
    public ResponseEntity<List<TaxDeductionDTO>> getTaxDeductions() {
        List<TaxDeductionDTO> taxDeductions = employeeService.calculateTaxDeductions();
        return ResponseEntity.ok(taxDeductions);
    }
    
    
    @GetMapping("/getEmployees")
    public ResponseEntity<String> getEmployeeDetails() {        
        return ResponseEntity.ok("Welcome to the application");
    }
    
    @GetMapping("/loss-of-pay")
    public BigDecimal calculateLossOfPay(@RequestParam BigDecimal salary) {
        return salary.divide(BigDecimal.valueOf(30), 2, BigDecimal.ROUND_HALF_UP);
    }
}
