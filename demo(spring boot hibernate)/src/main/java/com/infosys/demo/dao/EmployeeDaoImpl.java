package com.infosys.demo.dao;

	import java.util.List;

import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.demo.model.Employee;
@Repository
	public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	SessionFactory sessionFactory ;

	private Session getSession() {
	    return sessionFactory.getCurrentSession();
	}

		public String saveEmployee(Employee employee) {
			
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getCity());
			Long isSuccess = (Long)getSession().save(employee);
			if(isSuccess>=1) {
			return "Success"+ isSuccess;
			}else {
				return "Error while saving person";
			}
		}
	public	List<Employee> getAllEmployee(){
			List<Employee> list = getSession().createQuery("from Employee").list();
			return list;
		}
	}


