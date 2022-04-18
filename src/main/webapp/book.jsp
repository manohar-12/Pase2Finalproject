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
<title>payment</title>
</head>
<body>
<div align="center">

<font size="2"
face="verdana"
color="red">payment:</font>
<br>
<form action="payment" method="post">
card holder name:<input type="text" name="name" placeholder="name"><br>
Enter card number:<input type="number" name="cardno" placeholder="cardnumber"><br>
Enter CVV:<input type="password" name="cvv" placeholder="cvv"><br>
Amount:<input type="text" name="amount" placeholder="enter amount"><br>
<br>
<input type="submit" value="pay">

</form>
<form action="cancel"><input type="submit" value="cancel"></form>
</div>

</body>
</html>