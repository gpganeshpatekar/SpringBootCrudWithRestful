package com.demo.springbootcrudwithrestful.service;

import java.util.List;

import com.demo.springbootcrudwithrestful.model.Employee;

public interface EmployeeServiceI {
	
	public Employee employeeLogin(Employee employee);
	public Employee addEmployee(Employee employee);
	public List<Employee> addMultipleEmployee(List<Employee> employee);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(Integer empId);
	public List<Employee> getEmployeeByAge(Integer empAge);
	public Employee updateEmployee(Employee employee);
	public Employee updateAllEmployee(Employee employee);
	public Employee deleteEmployee(Integer empId);
	public Employee deleteAllEmployee(Employee employee);

}
