<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manufacture / Customer Registration</title>
<style type="text/css">
.middle{
position:absolute;
left:30%;
}


</style>
</head>
<body style="background-image: url('images/bg.jpg'); , background-size: cover;">
	<jsp:include page="navbar.jsp"></jsp:include>
	<font face="times new roman">
		<div class="middle">
			<font color="white"><h1>Manufacture / Customer Registration</h1></font>
			<form action="Servereg" method="post">
				<table style="with: 50%">
					<tr>
						<td style="color: white">UserName</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td style="color: white">Password</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td style="color: white">Customer=1/Manufacture=0</td>
						<td><input type="text" name="number" /></td>
					</tr>
					<tr>
						<td style="color: white">contact number</td>
						<td><input type="text" name="cnum" /></td>
					</tr>
					<tr>
						<td style="color: white">Address</td>
						<td><input type="text" name="Address" /></td>
					</tr>
						
				</table>
				<font color="black"> <input type="submit" value="Submit" />
				</font>
			</form>
		</div>
</body>
</html>