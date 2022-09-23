<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Success</title>
</head>
<body>

<h2 style="text-align:center;color:mediumseagreen;"><strong><span><%=session.getAttribute("empId") %></span> you are successfully logged out. </strong></h2>
<h3 ><a href="http://localhost:8080/Task/login.jsp" >Want to sign in again</a></h3>
</body>
</html>