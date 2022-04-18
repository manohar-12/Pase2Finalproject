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
<title>admin page</title>
</head>
<body>
<div align="center">
<font size="10"
face="verdana"
color="yellow">Welcome to FlyAway Airline:</font>
<br>
<font size="2"
face="verdana"
color="red">admin login:</font>
<br>
<form action="adminlogin" method="post">
Email:<input type="email" name="email" placeholder="enter email"><br>
Password:<input type="password" name="pass" placeholder="enter password"><br><br>
<input type="submit" value="login">

</form>
</div>
</body>
</html>