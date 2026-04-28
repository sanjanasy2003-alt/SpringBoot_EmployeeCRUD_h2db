package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeRepository repository;
	
	public EmployeeController(EmployeeRepository repository) {
		this.repository=repository;
	}
	
	@PostMapping
	public Employee createEmp(@RequestBody Employee s) {
		return repository.save(s);
	}
	
	@GetMapping("/byname")
	public List <Employee> getEmployeeByName(@RequestParam String name){
		return repository.findByName(name);
		
	}
	
	@GetMapping("/bydepartment")
	
	public List <Employee> getEmployeeByDepartment(@RequestParam String department){
		return repository.findByDepartment(department);
	}
	
	@GetMapping("/bysalary")
	
	public List <Employee> getEmployeeBySalary(@RequestParam double salary){
		return repository.findBySalary(salary);
	}
	
	@GetMapping("/and")
	public List<Employee> getEmpbynmanddept(@RequestParam String name, @RequestParam String department){
		return repository.findByNameAndDepartment(name, department);
	}
	
	@GetMapping("/rangesalary")
	
	public List<Employee> getEmployeeSalaryRange(@RequestParam double minSalary, @RequestParam double maxSalary){
		return repository.findBySalaryBetween(minSalary,maxSalary);
	}
	
	@GetMapping("/or")
	public List<Employee> getByNameOrDept(@RequestParam String name,
	                                      @RequestParam String department) {
	    return repository.findByNameOrDepartment(name, department);
	}
	@GetMapping("/and-or")
	public List <Employee> getByNmanddeptorsal(@RequestParam String name, @RequestParam String department,@RequestParam double salary){
		return repository.findByNameAndDepartmentOrSalary(name,department,salary);
	}

}
