<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-image: url(aeroplane.jpg);
	background-size: cover;
	background-position: fixed;
}
</style>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>

<div align="center">
<font size="10"
face="verdana"
color="yellow">Welcome to FlyAway Airline Bookings</font>
<br>
<font size="2"
face="verdana"
color="red">user login:</font>
<br>
<form action="login" method="post">
Email:<input type="email" name="email" placeholder="enter email"><br>
Password:<input type="password" name="pass" placeholder="enter password"><br><br>
<input type="submit" value="login">

</form>
<a href="register.jsp"><font size="2"
face="verdana"
color="pink">Register:</font></a>
<br>
<a href="admin.jsp"><font size="2"
face="verdana"
color="pink">Login as admin:</font></a>

</div>
</body>
</html>