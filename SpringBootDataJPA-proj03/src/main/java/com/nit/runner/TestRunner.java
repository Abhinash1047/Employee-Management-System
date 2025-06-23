package com.nit.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.controller.EmployeeController;
import com.nit.entity.Employee;
@Component("run")
public class TestRunner implements CommandLineRunner {

	@Autowired
    private EmployeeController control;
	@Override
	public void run(String... args) throws Exception 
	{
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			while(true)
			{
				System.out.println("Employee Management System");
				System.out.println("1.Add Employee record \n \t"
						                  +"2.Get Employee Details By Id \n \t"
						                  +"3.Add Multiple Employee Records \n \t "
						                  +"4.Employee Exits Or not By Id \n \t"
						                  +"5.Get No Of Employee Count In Table \n \t"
						                  +"6.Get All Employee Details \n \t"
						                  +"7.Get Employee Details By Id's \n \t"
						                  +"8.Delete Employee Details By Id \n \t"
						                  +"9.Delete All Employee Details \n \t"
						                +"10.Delete Employees By Id's \n \t"
						                +"11.Exit");
				System.out.println("Select Any option from above...");
				int n=s.nextInt();
				switch(n)
				{
				case 1:
					
					System.out.println("Enetr Employee Name :");
					String name=s.next();
					System.out.println("Enetr Employee Adress :");
					String add=s.next();
					System.out.println("Enter Employee Salary :");
					Double sal=s.nextDouble();
					
					Employee e1= new Employee( name, add, sal);
					String employeeDetails = control.addEmployeeDetails(e1);
					System.out.println(employeeDetails);
					
					break;
				case 2:
					
					System.out.println("Enter Employee Id :");
					Long i= s.nextLong();
					Optional<Employee> emp = control.getEmployeeDetailsById(i);
                    System.out.println(emp);
					break;
				case 3:
					System.out.println("how many Employee do you want add :");
					int c=s.nextInt();
					List<Employee> list= new ArrayList<Employee>();
					for(int j =0;j<c;j++)
					{
						System.out.println("details of emp:"+(j+1));
						System.out.println("Enetr Employee Name :");
						String name1=s.next();
						System.out.println("Enetr Employee Adress :");
						String add1=s.next();
						System.out.println("Enter Employee Salary :");
						Double sal1=s.nextDouble();
						list.add(new Employee( name1,add1, sal1));
					}
					Iterable<Employee> all = control.addAllEmployessDetails(list);
					all.forEach(System.out::println);
					System.out.println(all);
					break;
				case 4:
					System.out.println("Enter Employee Id :");
					Long id= s.nextLong();
					
					boolean k = control.employeeDetailsExit(id);
					System.out.println("employee details exit ?"+k);
					break;
				case 5:
					Long e = control.getEmployeeCount();
					System.out.println("No Of Employee details available:"+e);
					break;
				case 6:
					Iterable<Employee> allEmployessDetails = control.getAllEmployessDetails();
					allEmployessDetails.forEach(System.out::println);
					break;
				case 7:
					System.out.println("Enetr no of employess Id's :");
					int k1=s.nextInt();
					List<Long> li= new ArrayList<Long>();
					for(int m=0;m<k1;m++)
					{
						System.out.println("Employee Id of :"+(m+1));
						System.out.println("Enter Employee Id :");
						Long id1= s.nextLong();
						
						li.add(id1);
					}
					Iterable<Employee> empid = control.getEmployeeDetailsByIds(li);
					empid.forEach(System.out::println);
					break;
				case 8:
					System.out.println("Enter Employee Id :");
					Long id2= s.nextLong();
					String de = control.deleteEmployeeById(id2);
					System.out.println(de);
					break;
				case 9:
					String deall = control.deleteAllEmployee();
					System.out.println(deall);
					break;
				case 10:
					System.out.println("Enetr no of employess Id's :");
					int k2=s.nextInt();
					List<Long> li2= new ArrayList<Long>();
					for(int m1=0;m1<k2;m1++)
					{
						System.out.println("Employee Id of :"+(m1+1));
						System.out.println("Enter Employee Id :");
						Long id3= s.nextLong();
						
						li2.add(id3);
					}
					String deid = control.deleteEmployeeByIds(li2);
					System.out.println(deid);
					break;
				case 11:
					System.out.println("Exited.....");
					System.exit(0);
				break;
				       
				
					default : System.out.println("Invalid Option Try Again..");
					break;
				}
			
			}
			  
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
