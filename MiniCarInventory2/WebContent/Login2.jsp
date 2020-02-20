<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: url('images/bg.jpg'); , background-size: cover;">
<jsp:include page="navbar.jsp"></jsp:include>
<center>
<font color="white" face="times new roman">
<h1>Manufacturer Login</h1>
</font>
<form action="ManuFac" method="post">
 

  <div class="container">
	<font color="white">    <label for="uname"><b>Username</b></label></font>
    <input type="text" placeholder="Enter Username" name="username" >
<br>
   	<font color="white"> <label for="psw"><b>Password</b></label></font>
    <input type="password" placeholder="Enter Password" name="password" >
<br>
    <button type="submit">Login</button>
    </form>
  </div>

 
</form>
</center>
</body>
</html>