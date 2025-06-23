package com.nit.repository;

import org.springframework.data.repository.CrudRepository;

import com.nit.entity.Employee;

public interface IEmployeeRepo extends CrudRepository<Employee, Long> {

}
