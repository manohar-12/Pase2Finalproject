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
<title>add flight</title>
</head>
<body>
<div align="center">
<font size="2"
face="verdana"
color="red">Details of flight to add:</font>
<br>
<form action="add" method="post">

Airline:<input type="text" name="name" placeholder="name"><br>
from:<input type="text" name="from" placeholder="from"><br>
to:<input type="text" name="to" placeholder="to"><br>
Date:<input type="text" name="date" placeholder="date"><br><br>
<input type="submit" value="update">

</form>
</div>
</body>
</html>