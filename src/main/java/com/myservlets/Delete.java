package com.myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.javabeans.Employee;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	       
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter o=response.getWriter();
			response.setContentType("text/html");
			int empId=Integer.parseInt(request.getParameter("empId"));
		
			Employee emp=new Employee();
			emp.setEmpId(empId);
			
			EmployeeDao e=new EmployeeDao();
			e.delete(empId);
		}

	}