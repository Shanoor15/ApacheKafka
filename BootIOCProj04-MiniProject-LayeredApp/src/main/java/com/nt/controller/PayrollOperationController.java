//PayrollOperationController.java
package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("empController")
public class PayrollOperationController {

	@Autowired
	private IEmployeeMgmtService empService;
	


	public List<Employee> fetchEmployeesByDesgs(String desg1,String desg2,String desg3) throws Exception{

	//use service
		List<Employee> list=empService.setEmployeeByDesgs(desg1,desg2,desg3);
		System.out.println("PayrollOperationController.fetchEmployeesByDesgs()");
		return list;
	}
	
}

