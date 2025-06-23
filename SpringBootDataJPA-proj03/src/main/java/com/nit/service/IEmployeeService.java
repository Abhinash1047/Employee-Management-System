package com.nit.service;

import java.util.Optional;

import com.nit.entity.Employee;

public interface IEmployeeService 
{
     public String addEmployee(Employee emp);
     public Optional<Employee> getEmployeeById(Long id);
     public Iterable<Employee> addAllEmployess(Iterable<Employee> emp);
     public boolean employeeExit(Long id);
     public Long getCount();
     public Iterable<Employee> getAllEmployess();
     public Iterable<Employee> getEmployeeByIds(Iterable<Long> ids);
     public String deleteById(Long id);
     public String deleteAll();
     public String deleteByIds(Iterable<Long> ids);
     
}
