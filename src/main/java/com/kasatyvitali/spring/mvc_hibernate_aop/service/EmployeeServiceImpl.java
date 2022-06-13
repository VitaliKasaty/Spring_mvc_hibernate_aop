package com.kasatyvitali.spring.mvc_hibernate_aop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasatyvitali.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.kasatyvitali.spring.mvc_hibernate_aop.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional //Передаёт Spring'у ответственность за открытие/закрытие
	public List<Employee> getAllEmployees() {		
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);		
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {		
		return employeeDAO.getEmployee(id);
	}

}
