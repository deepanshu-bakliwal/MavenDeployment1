package com.lti.training.day7.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Data Access Object
public class EmployeeDao {
	// public void insert(int empno,String name,double salary) {
	public void insert(Employee emp)throws DataAccessException { 
		Connection conn = null;
		PreparedStatement pstmt = null; 
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		//pstmt = conn.prepareStatement("insert into TAB_EMP values(?,?,?)");
		
		
		 pstmt.setString(1,emp.getName());
         pstmt.setInt(2,emp.getEmpno() );
         pstmt.setDouble(3, emp.getSalary());	
         pstmt.executeUpdate();
         }
		catch(Exception e){
			
		throw new DataAccessException("problem while inserting data", e);
		}
		finally{
			}
		try {pstmt.close();} 
		catch (Exception e) {	}
		
	}
	public List<Employee> fetchAll() throws DataAccessException{
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			pstmt = conn.prepareStatement("select* from TAB_EMP");
			rs = pstmt.executeQuery();
			List<Employee>list = new ArrayList<>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt("ENO"));
                emp.setName(rs.getString("ename"));
                emp.setSalary(rs.getDouble("salary"));
                list.add(emp);
                }
		return list;
		}
		catch(ClassNotFoundException | SQLException e) {
			throw new DataAccessException("problem while featching");
		}
		finally {
			try {rs.close();} catch(Exception e){}
			try {pstmt.close();}catch(Exception e) {}
			try {conn.close();} catch(Exception e) {}
		}
		
		
		
	}
}
