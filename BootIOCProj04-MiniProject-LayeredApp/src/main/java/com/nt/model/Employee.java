//Employee.java (JAVA BEAN)
package com.nt.model;

import lombok.Data;
import lombok.ToString;

@Data
public class Employee {

	private Integer empno;
	private String ename;
	private String job;
	private Double salary;
	private Integer deptno;
	private Double grossSalary;
	private Double netSalary;
}

