package com.myservlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.javabeans.Employee;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName=request.getParameter("empName");
		String empEmail=request.getParameter("empEmail");
//		String uniqueCode=request.getParameter("uniqueCode");
		LocalDateTime d=  LocalDateTime.now();
		Employee e=new Employee(empId,empName,empEmail);
		EmployeeDao rd=new EmployeeDao();
		rd.Insert(e);
		RequestDispatcher d1= request.getRequestDispatcher("login.jsp");
		d1.forward(request, response);
		
}


}
