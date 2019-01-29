package com.lti.training.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lti.training.dto.*;
@WebServlet("/AddEmployeeServlet1")
public class AddEmployeeServlet extends HttpServlet {
	
	Employee e=null;
	EmployeeDao dao= new EmployeeDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 	   String a = request.getParameter("empno");
 	   String b =request.getParameter("name");
 	   String c = request.getParameter("salary");
 	  
 	   
 	  e =new com.lti.training.dto.Employee();
 	   e.setEmpno(a);
 	   e.setName(b);
 	   e.setSalary(c);
 	   dao.add(e);
 	   HttpSession session=request.getSession();
 	   session.setAttribute("message", "Recorded added successfully");
 	   response.sendRedirect("addEmployee.jsp");
    }
}
