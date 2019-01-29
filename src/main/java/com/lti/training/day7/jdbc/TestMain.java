package com.lti.training.day7.jdbc;

import java.util.List;

import com.lti.training.dto.Employee;

public class TestMain {
	public static void main(String[] args) throws DataAccessException {
		//to add data into table
		
	/*	EmployeeDao edao=new EmployeeDao();
		Employee e=new Employee();
		e.setEmpno(1122);
		e. setName("jan");
		e.setSalary(5400);
		Employee e2 = new Employee();
		e2.setEmpno(2222);
		e2.setName("DDD");
		e2.setSalary(23333);
		try {
		edao.insert(e); 
		edao.insert(e2);
	}
		catch(DataAccessException ee) {
		ee.printStackTrace();
		}
	*/
		EmployeeDao empDao=new EmployeeDao();
		try {
			List <Employee>list=empDao.fetchAll();
			for(Employee e:list)
			{
				System.out.println("emp Name:"+e.getName());
				System.out.println("empNo: "+e.getEmpno());
				System.out.println("salary: "+e.getSalary());
			}
		}
		catch(Exception e) {
			
		}
}}
