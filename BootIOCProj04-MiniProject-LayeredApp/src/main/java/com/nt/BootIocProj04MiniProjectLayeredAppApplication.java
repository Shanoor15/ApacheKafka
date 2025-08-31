//client application
package com.nt;

import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj04MiniProjectLayeredAppApplication {

	public static void main(String[] args) throws Exception {
		System.out.println("BootIocProj04MiniProjectLayeredAppApplication.main()(STRAT)");
		ApplicationContext ctx=SpringApplication.run(BootIocProj04MiniProjectLayeredAppApplication.class, args);
		//get Controller class obj ref 
		PayrollOperationController controller=ctx.getBean("empController",PayrollOperationController.class);
		//read inputs from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee desg1::");
		String desg1=sc.next();
		System.out.println("enter employee desg2::");
		String desg2=sc.next();
		System.out.println("enter employee desg3::");
		String desg3=sc.next();
		
		try
		{
			List<Employee> list=controller.fetchEmployeesByDesgs(desg1,desg2,desg3);
			list.forEach(emp->{
				System.out.println(emp);
			});
			
	}//try
		catch(Exception e){
			System.out.println("Internal Problem----Try Again::"+e.getMessage());
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
		System.out.println("BootIocProj04MiniProjectLayeredAppApplication.main()(END)");
	}
	
}

