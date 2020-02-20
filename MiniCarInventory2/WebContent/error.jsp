<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body  style="background-image: url('images/bg.jpg'); , background-size: cover;">
<jsp:include page="navbar.jsp"></jsp:include>
<font color="white"><h1> Not a valid car name</h1>
<h2>Do u want to go back or exit</h2></font>
<form action="showdatabase.jsp" method="post">
<button type="submit" >BACK</button>  

</form>
<form action="thankcus.jsp" method="post">
<br>
<button type="submit" >Exit</button>    

</form>

</body>
</html>