package com.nit.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nit.entity.Employee;
import com.nit.repository.IEmployeeRepo;

@Service("empservice")
public class EmployeeService implements IEmployeeService 
{

	@Autowired
	private IEmployeeRepo emprepo;

	@Override
	public String addEmployee(Employee emp) 
	{
	      Employee save = emprepo.save(emp);	
	      
		return "saved employee id :"+save.getEmpid();
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		return Optional.ofNullable(emprepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id....")));
		
	}

	@Override
	public Iterable<Employee> addAllEmployess(Iterable<Employee> emp) {
		Iterable<Employee> saveAll = emprepo.saveAll(emp);
		List<Employee> list=(List)saveAll;
		List< Long> list2 = list.stream().map(a->a.getEmpid()).toList();
		list2.forEach(System.out::println);
		return saveAll;
	}

	@Override
	public boolean employeeExit(Long id) {
		boolean existsById = emprepo.existsById(id);
		return existsById;
	}

	@Override
	public Long getCount() {
		long count = emprepo.count();
		return count;
	}

	@Override
	public Iterable<Employee> getAllEmployess() {
		Iterable<Employee> all = emprepo.findAll();
		return all;
	}

	@Override
	public Iterable<Employee> getEmployeeByIds(Iterable<Long> ids) {
		Iterable<Employee> allById = emprepo.findAllById(ids);
		return allById;
	}

	@Override
	public String deleteById(Long id) {
		Optional<Employee> byId = emprepo.findById(id);
		long count = byId.stream().count();
		emprepo.deleteById(id);
		return count==0 ? "No record deleted":count+" no of record deleted";
	}

	@Override
	public String deleteAll() {
		long count = emprepo.count();
		emprepo.deleteAll();
		
		return count +"No of records are deleted";
	}

	@Override
	public String deleteByIds(Iterable<Long> ids) {
		Iterable<Employee> allById = emprepo.findAllById(ids);
		long count = StreamSupport.stream(allById.spliterator(), false).count();
		emprepo.deleteAllById(ids);
		return count+" :records are deleted";
	}
	

}
