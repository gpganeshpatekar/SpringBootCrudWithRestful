package com.demo.springbootcrudwithrestful.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootcrudwithrestful.model.Employee;
import com.demo.springbootcrudwithrestful.service.EmployeeServiceI;

@RestController
public class EmployeeController {
	
	private EmployeeServiceI employeeServiceI;
	
	@PostMapping(value = "/empLogin",consumes = "application/json",produces = "application/json")
	private ResponseEntity<Employee> empLogin(Employee employee){
		Employee employee1 = employeeServiceI.employeeLogin(employee);
		if(employee1==null) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Employee>(employee1,HttpStatus.OK);
	}
	
	@PostMapping(value = "/addEmp",consumes = "application/json",produces = "application/json")
	private ResponseEntity<Employee> addEmpployee(Employee employee){
		Employee employee1 = employeeServiceI.addEmployee(employee);
		return new ResponseEntity<Employee>(employee1,HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/getAllEmp",produces = "application/json")
	private ResponseEntity<List<Employee>> getAllEmployee(){

		List<Employee> employee1 = employeeServiceI.getAllEmployee();
		return new ResponseEntity<List<Employee>>(employee1, HttpStatus.OK);
	}
	@GetMapping(value = "/getEmpByAge/{empAge}",produces = "application/json")
	public ResponseEntity<List<Employee>> getEmployeeByAge(@PathVariable("empAge") Integer empAge){
		List<Employee> employee1 = employeeServiceI.getEmployeeByAge(empAge);
		if(employee1==null) {
			return new ResponseEntity<List<Employee>> (HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Employee>> (employee1,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEmpByAge/{empId}",produces = "application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") Integer empId){
		Employee employee1 = employeeServiceI.getEmployeeById(empId);
		if(employee1==null) {
			return new ResponseEntity<Employee> (HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Employee> (employee1,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateEmp",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Employee> updateEmployee(Employee employee){
		Employee employee1 = employeeServiceI.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee1,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteEmp/{empId}",produces = "application/json")
	public ResponseEntity<String> deleteEmployee(@PathVariable("empId") Integer empId){
		Employee employeee1 = employeeServiceI.deleteEmployee(empId);
		if(employeee1==null) {
			
			String msg = "Employee Id Doesn't Exists..\nPlease Enter Valid Employee ID To Delete The Data";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_GATEWAY);
		}
		String deletemsg = "Employee "+empId+" Deleted Successfully.. ";
		return new ResponseEntity<String> (deletemsg,HttpStatus.OK);
	}

}
