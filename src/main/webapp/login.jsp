<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Login Page</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="bg-img">
<form action="Login" method="post" class="login-form">
<center><h1 style="text-align:center">Employee Login</h1>
<hr style="background-color:black;width:200px;height:3px;"></center>
<div class="container">
<b></b><input type="text" name="empId" placeholder="enter your empId"><br>
<b></b><input type="text" name="empName" placeholder="enter your empName"><br>
<b><input type="text" name="empEmail"placeholder="enter your empEmail"><br>
<b></b><input type="password" name="password"placeholder="enter your password"><br><br>
<input type="submit" value="login" class="btn"> 
<h3>Don't have an account? <span><a href="register.jsp">Sign up</a></span>&nbsphere</h3>


</div>
</form>
</div>

</body>
</html>