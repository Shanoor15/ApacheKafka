//EmployeeDAOImpl.java
package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nt.BootIocProj04MiniProjectLayeredAppApplication;
import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

  private static final String QUERY = " SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP1 WHERE JOB IN(?,?,?) ORDER BY JOB";
	
	@Autowired
	private DataSource ds;
	
	@Override
	public List<Employee> getEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
	    List<Employee> list = null;
	    System.out.println("EmployeeDAOImpl.getEmployeesByDesgs()");
	    try (
	        Connection con = ds.getConnection();
	        PreparedStatement ps = con.prepareStatement(QUERY);
	    ) {
	    	System.out.println(ps+" stmt");
	    
	        ps.setString(1, desg1);
	        ps.setString(2, desg2);
	        ps.setString(3, desg3);
	        
	        System.out.println("DESG1: " + desg1);
	        System.out.println("DESG2: " + desg2);
	        System.out.println("DESG3: " + desg3);
	        
	        try(ResultSet rs = ps.executeQuery()){
	        System.out.println(rs+" result  ");
	            list = new ArrayList<Employee>();
	            while (rs.next()) {
	                Employee emp = new Employee();
	                emp.setEmpno(rs.getInt(1));
	                emp.setEname(rs.getString(2));
	                emp.setJob(rs.getString(3));
	                emp.setSalary(rs.getDouble(4));
	                emp.setDeptno(rs.getInt(5));
	                list.add(emp);
	            }//while
	    }//try2
	    
	}//try1
	    
	 catch(SQLException se) {
		 se.printStackTrace();
		 throw se;
	 }
	    catch(Exception e) {
	    	e.printStackTrace();
	    	throw e;
	    }
	    return list;
	}
}

