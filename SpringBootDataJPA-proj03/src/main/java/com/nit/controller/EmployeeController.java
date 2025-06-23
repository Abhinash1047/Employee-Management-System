package com.nit.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.entity.Employee;
import com.nit.service.IEmployeeService;

@Controller("empcontroller")
public class EmployeeController
{
	@Autowired
      private IEmployeeService service;
	
	public String addEmployeeDetails(Employee emp)
	{
		String employee = service.addEmployee(emp);
		return employee;
		
	}
	
    public Optional<Employee> getEmployeeDetailsById(Long id)
    {
    	Optional<Employee> employeeById = service.getEmployeeById(id);
		return employeeById;
    	
    }
    public Iterable<Employee> addAllEmployessDetails(Iterable<Employee> emp)
    {
    	Iterable<Employee> allEmployess = service.addAllEmployess(emp);
		return allEmployess;
    	
    }
    public boolean employeeDetailsExit(Long id)
    {
    	boolean employeeExit = service.employeeExit(id);
		return employeeExit;
    	
    }
    public Long getEmployeeCount()
    {
    	Long count = service.getCount();
		return count;
    	
    }
    public Iterable<Employee> getAllEmployessDetails()
    {
    	Iterable<Employee> allEmployess = service.getAllEmployess();
    	
		return allEmployess;
    	
    }
    public Iterable<Employee> getEmployeeDetailsByIds(Iterable<Long> ids)
    {
    	Iterable<Employee> employeeByIds = service.getEmployeeByIds(ids);
		return employeeByIds;
    	
    }
    public String deleteEmployeeById(Long id)
    {
    	String deleteById = service.deleteById(id);
		return deleteById;
    	
    }
    public String deleteAllEmployee()
    {
    	String deleteAll = service.deleteAll();
		return deleteAll;
    	
    }
    public String deleteEmployeeByIds(Iterable<Long> ids) 
    {
    	String deleteByIds = service.deleteByIds(ids);
		return deleteByIds;
    	
    }
}
