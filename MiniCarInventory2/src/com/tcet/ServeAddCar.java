package com.tcet;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

/**
 * Servlet implementation class ServeAddCar
 */
@WebServlet("/ServeAddCar")
public class ServeAddCar extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cartype=request.getParameter("cartype");
		String carprice=request.getParameter("carprice");
		String carname=request.getParameter("carname");
		String imagelink=request.getParameter("imagelink");
		
		
		DBConnect dbc=new DBConnect();
		
		if(dbc.car(carname, cartype, carprice,imagelink)) {
		    	response.sendRedirect("AddCar.jsp");	
				
	}
	}
}
