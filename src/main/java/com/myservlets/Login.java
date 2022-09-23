package com.myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDao;
import com.javabeans.Employee;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
//	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");
		HttpSession se= request.getSession();
		EmployeeDao ed=new EmployeeDao ();
		Employee emp=new Employee();
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName=request.getParameter("empName");
		String empEmail=request.getParameter("empEmail");
		se.setAttribute("empId", empId);
		se.setAttribute("EmpName", empName);
		se.setAttribute("EmpEmail", empEmail);
		
//		
//		 UUID uniqueCode=UUID.randomUUID();
////	       
//	        p.println(uniqueCode);
////	        
//	        if(uniqueCode!=null && empId!=0) {
//	            //wt.println("if statement");
////	            se.setUniqcode(uniqueCode);
////	            se.setEmpid(empId);
//////////	        	se.setAttribute("uniqueCode", uniqueCode);
//	        }
//	         
	
//		rd.forward(req, resp);
//		p.println(user+pass);
		
		Employee employee= ed.checkUser(empId);
		if (empId==employee.getEmpId()){
			System.out.println("Tesla");
//			RequestDispatcher rd= request.getRequestDispatcher("success.jsp");
//			rd.include(request, response);
			ed.updateEmpLogin(empId);
///////			boolean status=EmployeeDao.InsertLogindetails(employee);
			LocalDateTime l= LocalDateTime.now();
			p.println("<h1 style=\"text-align:center;color:dodgerblue;\"><strong>Welcome <span>"+empName+"</span></strong></h1>\r\n"
					+ "<form action=\"Logout?empId="+empId+" method=\"get\">\r\n"
					+ "<input type=\"submit\" value=\"logout\">");
			p.print("<h1> your logged at ");
			p.println(l);
			p.println("<br>");
			p.println();
			p.println();
			List<Employee> u= new ArrayList<>();
			u.addAll(ed.AllUser());
			p.println("<table cellspacing='0' width=50px border=2px>");
			p.println("<tr>");
			p.println("<td>empId</td>");
			p.println("<td>empName</td>");
			p.println("<td>empEmail<td>");
//			p.println("<td>uniquecode<td>");
			p.println("</tr>");
			for (Employee s:u) {
				p.println("<tr>");
				p.println("<td>"+s.getEmpId()+"</td>");
				p.println("<td>"+s.getEmpName()+"</td>");
				p.println("<td>"+s.getEmpEmail()+"</td>");
//				p.println("<td>"+s.getUniqueCode()+"</td>");
				p.println("<td>"+"<a href='Delete?empId="+s.getEmpId()+"'\"+\" >Delete</a></td>");
				p.println("<td>"+"<a href=''>Update</a></td>");
				p.println("</tr>");
				
			}
			p.println("</table>");

			
			
			}
		else {
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			p.println("<p>Invalid user or password.Try login again.");
			p.println("<p>Not an existing user?<span><a href=\"http://localhost:8080/Task/register.jsp\" style=\"text-decoration:none;color:green;\"> Sign Up</a></span><p> ");
			

		}
	
			
		}
	

	}


