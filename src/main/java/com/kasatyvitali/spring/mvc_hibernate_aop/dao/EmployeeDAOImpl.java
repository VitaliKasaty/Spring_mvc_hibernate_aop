package com.kasatyvitali.spring.mvc_hibernate_aop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kasatyvitali.spring.mvc_hibernate_aop.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	//Будет автоматически внедрена зависимость к бинам в applicationContex
	//отвечающая за подлкючения к БД
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional //Передаёт Spring'у ответственность за открытие/закрытие транзакций
	public List<Employee> getAllEmployees() {
		
		Session session = sessionFactory.getCurrentSession();
		
//		Query<Employee> query = session.createQuery("from Employee", Employee.class);
//		List<Employee> allEmployees = query.getResultList();
		
		//Более короткий вариант получения списка из БД
		List<Employee> allEmployees = session.createQuery("from Employee", Employee.class)
				.getResultList();
		
		return allEmployees;
	}

}
