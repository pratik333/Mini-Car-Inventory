package com.tcet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServeMani
 */
@WebServlet("/ManuFac")
public class ServeMani extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		String page="AddCar.jsp";
		
		DBConnect dbc = new DBConnect();
		if(dbc.ManuFac(username, password))
				{
					response.sendRedirect(page);
				}
		
		else
		{
			response.sendRedirect("manuerror.jsp");
		}
		
		
	}

}
