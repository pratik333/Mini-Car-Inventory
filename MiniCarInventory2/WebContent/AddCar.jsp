<%@page import="com.tcet.DBConnect"%>
<%@page import="java.util.ArrayList"%> 

<%@page import ="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
   color:white;
  border: 1px solid black;
}
</style>
</head>
<body
	style="background-image: url('images/bg.jpg'); , background-size: cover;">
	<jsp:include page="navbar.jsp"></jsp:include>
	<font face="times new roman"> 
	<font color="white"><h1>Add cars for customers to see</h1></font>
	<form action="ServeAddCar" method="post">
		<tr>
			<td><font color="white">Car Name
	</font>
	</td>
	<td><input type="text" name="carname" /></td>

	<td><font color="white">Car Type</font></td>
	<td><input type="text" name="cartype" /></td>

	<td><font color="white">Car price</font></td>
	<td><input type="text" name="carprice" /></td>
	<td><font color="white">image link</font></td>
	<td><input type="text" name="imagelink" /></td>
	</tr>
	<br>
	<input type="submit" value="Submit" />
	<br>
	</form>
	<form action="thanku.jsp" method="post">
	<button type="submit" action="thanku.jsp">Added All Cars</button>
	</form>
	
	</font>
	<br/>
	<table class="table table-hover">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">CAR NAME</th>
	      <th scope="col">CAR TYPE</th>
	      <th scope="col">CAR PRICE</th>
	      <th scope="col">IMAGE LINK</th>
	    </tr>
	  </thead>
	  <tbody>
	    
	  
	<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
	<% 
	Connection con;
    Statement st;
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3307/tcet";
    final String DUSER = "root";
    final String DPASS = "root";
    String query;
    int executeUpdate;
    ResultSet rs;
    try {
    	
    	 	Class.forName(JDBC_DRIVER);
            
            // To set up a connect
            con = DriverManager.getConnection(DB_URL,DUSER,DPASS);
            
            // To execute statement 
            st = con.createStatement();
            // Auto connects to database
            query = String.format("SELECT * from carmodels");
            rs = st.executeQuery(query);
            while(rs.next()){
            	out.println("<tr>");
            		out.println("<td>");
	            		out.println(rs.getString("carname"));
	            	out.println("<td>");
	            		out.println(rs.getString("cartype"));
	            	out.println("<td>");
	            		out.println(rs.getString("carprice"));
	            	out.println("<td>");
	            		out.println(rs.getString("imagelink"));
            	out.println("</tr>");
            }
    
    }
    catch(Exception e){
    	System.out.println(e);
    }
    
	%>
	</tbody>
	</table>
</body>
</html>