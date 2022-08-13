package com.demo.springbootcrudwithrestful.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.springbootcrudwithrestful.model.Employee;
import com.demo.springbootcrudwithrestful.service.EmployeeServiceI;

@Repository
public class EmployeeDaoImpl implements EmployeeServiceI {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Employee employeeLogin(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		String hql = "from employee";
		Query query = session.createQuery(hql);
		List <Employee>resultList = query.getResultList();
		for(Employee employee1:resultList) {
			if(employee.getEmpEmail().equals(employee1.getEmpEmail()) && employee.getEmpPassword().equals(employee1.getEmpPassword())) {
				return employee1;
			}
		}
		return null;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		session.beginTransaction();
		Serializable employee1 = session.save(employee);
		session.getTransaction().commit();
		return (Employee) employee1;
	}

	@Override
	public List<Employee> addMultipleEmployee(List<Employee> employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = sf.openSession();
		String hql = "from employee";
		Query query = session.createQuery(hql);
		List list = query.getResultList();
		return list;
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Employee employee1 = session.get(Employee.class, empId);
		return employee1;
	}

	@Override
	public List<Employee> getEmployeeByAge(Integer empAge) {
		Session session = sf.openSession();
		String hql = "from employee where empAge > :empAge";
		Query query = session.createQuery(hql);
		query.setInteger("empAge", empAge);
		List listByAge = query.list();
		return listByAge;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(employee);
		session.getTransaction().commit();
		session.close();
		
		Session session1 = sf.openSession();
		Employee employee1 = session1.get(Employee.class, employee.getEmpId());
		session1.close();
		
		return employee1;
	}

	@Override
	public Employee updateAllEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteEmployee(Integer empId) {
		Session session = sf.openSession();
		Employee employee1 = session.get(Employee.class, empId);
		if(employee1!=null) {
			session.beginTransaction();
			session.delete(employee1);
			session.getTransaction().commit();
		}
		return employee1;
	}

	@Override
	public Employee deleteAllEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
