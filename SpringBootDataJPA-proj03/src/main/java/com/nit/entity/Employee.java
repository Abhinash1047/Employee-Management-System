package com.nit.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Employee_spring1")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee
{
	public Employee(  String empName ,String address, Double empSalary) 
	{
		 this.empName=empName;
		 this.address=address;
		 this.empSalary=empSalary;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="epid")
    private Long empid;
	
	@Column(name="ename",length = 30)
	private String empName;
	
	@Column(name="eaddress",length = 30)
	private String address;
	
	@Column(name = "esalary")
	private Double empSalary;
}
