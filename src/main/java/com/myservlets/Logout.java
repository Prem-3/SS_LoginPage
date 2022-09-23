package com.myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDao;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
//		String uniqueCode=request.getParameter("uniqueCode");
//		p.println(uniqueCode);
		response.setContentType("text/html");
		HttpSession hs=request.getSession();
		int empId=(int) hs.getAttribute("empId");
//		String empName= (String) hs.getAttribute("empName");
		LocalDateTime l= LocalDateTime.now();
		RequestDispatcher rd= request.getRequestDispatcher("logout.jsp");
		rd.include(request, response);
		EmployeeDao ed=new EmployeeDao();
		ed.updateEmpLogout(empId);
		p.println("<h2> your logged out at <h2>"+l);
//		 ////if(EmployeeDao.InsertLogoutdetails(uniqueCode)) {
//	            p.println("Inserted out date out time");
//	        }
//	        else {
//	            p.println("not updated");
//	        }
	}

}
