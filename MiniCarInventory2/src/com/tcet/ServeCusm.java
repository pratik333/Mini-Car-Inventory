package com.tcet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CusmLogin")
public class ServeCusm extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get customer details
		// Validate them 
		// call DBC cuslogin function.
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		
		DBConnect dbc = new DBConnect();
		
		if(dbc.cuslogin(username, password) == true)
		{	
			response.sendRedirect("showdatabase.jsp");
			
			
		}
		else
		{
			response.sendRedirect("cuserror.jsp");
		}
		
	
	}

}
