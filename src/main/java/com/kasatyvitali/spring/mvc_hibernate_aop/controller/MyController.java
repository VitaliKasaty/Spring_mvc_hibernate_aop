package com.kasatyvitali.spring.mvc_hibernate_aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kasatyvitali.spring.mvc_hibernate_aop.entity.Employee;
import com.kasatyvitali.spring.mvc_hibernate_aop.service.EmployeeService;

@Controller
public class MyController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String showAllEmployees(Model model) {		
		List<Employee> allEmployees = employeeService.getAllEmployees();
		model.addAttribute("allEmps", allEmployees);		
		return "all-employees";
	}	
	
	@RequestMapping("/addNewEmployee")
	public String addNewEmployee(Model model) {		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);		
		return "employee-info";
	}
	
	//Получаем из View атрибут employee(это заполненная форма с данными о работнике)
	//и вызываем метод saveEmployee
	@RequestMapping("saveEmployee")	
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {		
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

}
