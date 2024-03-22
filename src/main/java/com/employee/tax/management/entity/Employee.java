package com.employee.tax.management.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public BigDecimal getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(BigDecimal monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	
  public BigDecimal getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(BigDecimal yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
		private String employeeId;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private LocalDate doj;
	    private List<String> phoneNumbers;
	    private BigDecimal monthlySalary;
	    private BigDecimal yearlySalary;
	    
	  
		
		
		public Employee(String employeeId, String firstName, String lastName, String email, List<String> phoneNumbers, LocalDate doj, BigDecimal monthlySalary) {
			 this.employeeId = employeeId;
			 this.firstName =  firstName;
			 this.lastName =lastName;
			 this.phoneNumbers = phoneNumbers;
			 this.doj = doj;
			 this.monthlySalary = monthlySalary;
			 this.email = email;
			 
			}

}
