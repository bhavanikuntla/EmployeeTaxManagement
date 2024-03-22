package com.employee.tax.management.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.employee.tax.management.dto.EmployeeDTO;
import com.employee.tax.management.dto.TaxDeductionDTO;
import com.employee.tax.management.entity.Employee;
import com.employee.tax.management.repository.EmployeeRepository;

@Service
public class EmployeeService {	

	    @Qualifier
	    private EmployeeRepository employeeRepository;
	    
	    
	    private List<Employee> employees = new ArrayList<>();
	    
	    public EmployeeService() {
	        // Initialize some sample employees for demonstration
	        Employee employee1 = new Employee("1001", "John", "Doe", "test1@test.com", Arrays.asList("1111111111", "2222222222", "3333333333"), LocalDate.of(2022, 1, 15), BigDecimal.valueOf(5000));
	        Employee employee2 = new Employee("1002", "Jane", "Smith", "test2@test.com", Arrays.asList("1111111111", "2222222222", "3333333333"), LocalDate.of(2021, 6, 20),BigDecimal.valueOf(8000));
	        Employee employee3 = new Employee("1003", "Alice", "Johnson","test3@test.com",Arrays.asList("1111111111", "2222222222", "3333333333"),  LocalDate.of(2022, 3, 10), BigDecimal.valueOf(10000));

	        employees.add(employee1);
	        employees.add(employee2);
	        employees.add(employee3);
	    }

	    public List<TaxDeductionDTO> calculateTaxDeductions() {
	       // List<Employee> employees = employeeRepository.findAll();
	        List<TaxDeductionDTO> taxDeductions = new ArrayList<>();

	        for (Employee employee : employees) {
	            TaxDeductionDTO taxDeduction = calculateTaxDeduction(employee);
	            taxDeductions.add(taxDeduction);
	        }

	        return taxDeductions;
	    }

	    private TaxDeductionDTO calculateTaxDeduction(Employee employee) {
	        TaxDeductionDTO taxDeduction = new TaxDeductionDTO();
	        taxDeduction.setEmployeeId(employee.getEmployeeId());
	        taxDeduction.setFirstName(employee.getFirstName());
	        taxDeduction.setLastName(employee.getLastName());
	        taxDeduction.setYearlySalary(employee.getYearlySalary());

	        BigDecimal yearlySalary = employee.getYearlySalary();
	        BigDecimal taxAmount = BigDecimal.ZERO;
	        BigDecimal cessAmount = BigDecimal.ZERO;

	        if (yearlySalary.compareTo(BigDecimal.valueOf(250000)) > 0) {
	            if (yearlySalary.compareTo(BigDecimal.valueOf(500000)) <= 0) {
	                taxAmount = yearlySalary.subtract(BigDecimal.valueOf(250000)).multiply(BigDecimal.valueOf(0.05));
	            } else if (yearlySalary.compareTo(BigDecimal.valueOf(1000000)) <= 0) {
	                taxAmount = BigDecimal.valueOf(12500).add(yearlySalary.subtract(BigDecimal.valueOf(500000)).multiply(BigDecimal.valueOf(0.10)));
	            } else {
	                taxAmount = BigDecimal.valueOf(87500).add(yearlySalary.subtract(BigDecimal.valueOf(1000000)).multiply(BigDecimal.valueOf(0.20)));
	            }
	        }

	        if (taxAmount.compareTo(BigDecimal.ZERO) > 0) {
	            cessAmount = taxAmount.multiply(BigDecimal.valueOf(0.04)); // Cess is 4% of tax amount
	        }

	        taxDeduction.setTaxAmount(taxAmount);
	        taxDeduction.setCessAmount(cessAmount);

	        return taxDeduction;
	    }
	    
}
