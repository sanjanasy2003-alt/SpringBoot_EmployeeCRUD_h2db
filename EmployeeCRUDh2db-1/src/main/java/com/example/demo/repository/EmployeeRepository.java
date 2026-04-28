package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee ,Long >{
	List <Employee> findByName(String name);
	List <Employee> findByDepartment(String department);
	List <Employee> findBySalary (double salary);
	
	List <Employee> findByNameAndDepartment(String name,String department);
	
	List <Employee> findBySalaryBetween(double minSalary ,double maxSalary);
    
	List <Employee> findByNameOrDepartment(String name,String department);
	
	List<Employee> findByNameAndDepartmentOrSalary(String name,String department,double salary);
}
