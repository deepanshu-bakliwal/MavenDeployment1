package com.lti.training.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.lti.training.dto.Employee;

public class EmployeeDao {

	public void add(Employee e)   {
	
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Employee emp=e;
		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("dev-db.properties");
			Properties dbProps = new Properties();
			dbProps.load(is);
			
			String driverClassName= dbProps.getProperty("driverClassName");
			String url=dbProps.getProperty("url");
					
			String username = dbProps.getProperty("username");
			String password=dbProps.getProperty("password");
				
					
						
					
							
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url,username,password);
			
			psmt = conn.prepareStatement("insert into  employees1 values(?,?,?)");
			psmt.setString(2, emp.getName());
			psmt.setString(1, emp.getEmpno());
			psmt.setString(3, emp.getSalary());
			psmt.executeUpdate();	} 
		
		catch (ClassNotFoundException | SQLException |IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {rs.close();}
			catch (Exception e1) {}
			try {psmt.close();}
			catch (Exception e2) {}
			try {conn.close();}
			catch (Exception e3) {}
		}}
		
	    


	}


