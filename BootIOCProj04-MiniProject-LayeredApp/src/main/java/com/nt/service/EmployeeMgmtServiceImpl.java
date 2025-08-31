//EmployeeMgmtServiceImpl.java
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	
	@Autowired
	private IEmployeeDAO empDao;
	
	public EmployeeMgmtServiceImpl(){
		System.out.println("EmployeeMgmtServiceImpl::0-param constructor");
	}
	
	@Override
	public List<Employee> setEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		
		//convert the desgs to uppercass letter
		System.out.println("convert the desgs to uppercass letter");
		System.out.println("EmployeeMgmtServiceImpl.setEmployeeByDesgs()");
		/*desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();*/
		desg1 = desg1.trim().toUpperCase();
		desg2 = desg2.trim().toUpperCase();
		desg3 = desg3.trim().toUpperCase();
		
		System.out.println("DATA ON SERVICE IMPL");
		//use Service
		List<Employee> list=empDao.getEmployeesByDesgs(desg1, desg2, desg3);
		System.out.println(list);
		//process the List Collection
		list.forEach(emp->{
			//b.logic
			emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.4));
			emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2));
		
		});
		return list;
	}
	

}


