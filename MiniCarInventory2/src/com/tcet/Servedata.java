package com.tcet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servedata
 */
@WebServlet("/Servedata")
public class Servedata extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buycc=request.getParameter("buyc");
		DBConnect dbc=new DBConnect();
		
		if (dbc.buyc(buycc))
		{
			response.sendRedirect("thankuforbuy.jsp");
		
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
	}

}
