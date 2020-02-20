<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
td,th{
color:white;

}

</style>
</head>
<body style="background-image: url('images/bg.jpg'); , background-size: cover;">
<jsp:include page="navbar.jsp"></jsp:include>
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
	<font color="white"><h2> Which car do u need to buy type name</h2></font>
	<br>
	<form action="Servedata" method="post">
	<input type="text" placeholder="Enter car name " name="buyc" >
	<button type="submit" >BUY</button>
	<br>
	</form>
	<form action="thankcus.jsp">
	<br>
	<button type="submit" action="thankcus.jsp">Exit</button>
	</form>
	
</body>
</html>