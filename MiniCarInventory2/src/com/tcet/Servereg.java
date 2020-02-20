package com.tcet;

import com.tcet.DBConnect;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servereg")
public class Servereg extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DO NOT ALLOW GET
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		String num=request.getParameter("number");
		String contact=request.getParameter("cnum");
		String address=request.getParameter("Address");
		String page="Choice.jsp";
		DBConnect dbc = new DBConnect();
		if(dbc.register(username, password,num,contact,address)) {
			response.sendRedirect(page);
			
			dbc.close();
			
			
			
		}
		else
		{
			response.sendRedirect("notuser.jsp");
		}
		
	
	}
	
	

	
}
