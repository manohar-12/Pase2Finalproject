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
<title>Search airline</title>
</head>
<body>
<div align="center">
<font size="10"
face="verdana"
color="yellow">Welcome to FlyAway Airline Bookings</font>
<br>
<font size="2"
face="verdana"
color="red">Search Airline:</font>
<br>
<form action="display" method="post">
From:<input type="text" name="from" placeholder="From">
To:<input type="text" name="to" placeholder="To"><br>
Date:<input type="date" name="date" placeholder="Date"><br><br>
<input type="submit" value="search">
</form>
</div>

</body>
</html>