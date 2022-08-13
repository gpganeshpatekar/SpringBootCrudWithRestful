package com.demo.springbootcrudwithrestful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springbootcrudwithrestful.dao.EmployeeDaoI;
import com.demo.springbootcrudwithrestful.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI{
	
	@Autowired
	private EmployeeDaoI employeeDaoI;

	@Override
	public Employee employeeLogin(Employee employee) {
		// TODO Auto-generated method stub
		Employee employee1 = employeeDaoI.employeeLogin(employee);
		return employee1;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Employee employee1 = employeeDaoI.addEmployee(employee);
		return employee1;
	}

	@Override
	public List<Employee> addMultipleEmployee(List<Employee> employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employee1 = employeeDaoI.getAllEmployee();
		return employee1;
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Employee employee1 = employeeDaoI.getEmployeeById(empId);
		return employee1;
	}

	@Override
	public List<Employee> getEmployeeByAge(Integer empAge) {
		// TODO Auto-generated method stub
		List<Employee> employee1 = employeeDaoI.getEmployeeByAge(empAge);
		return employee1;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee employee1 = employeeDaoI.updateEmployee(employee);
		return employee1;
	}

	@Override
	public Employee updateAllEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub
		Employee employee1 = employeeDaoI.deleteEmployee(empId);
		return employee1;
	}

	@Override
	public Employee deleteAllEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
