<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Zone</title>
</head>
<body 
        style="background-image: url('images/bg.jpg'); , background-size: cover;">
<div>
		<jsp:include page="navbar.jsp"></jsp:include>
<center>
<font face="times new roman"> <font color="white">
<h1>Mini Car Inventory</h1>
</font>


<form action="Login.jsp" method="post">
<button type="submit" >Customer Login</button>    

</form>

<br>

<form action="Login2.jsp" method="post">
<button type="submit" action="Login2.jsp">Manufacturer Login</button>
</form>
<br>
<a href="Register.jsp" >Not a User?Register Here</a> 
     </font>
   </center>
</div>
</body>
</html>