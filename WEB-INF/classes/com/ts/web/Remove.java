package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.BusDAO;


@WebServlet("/Remove")
public class Remove extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String Remove = request.getParameter("Remove");
		String bId = request.getParameter("bus_id");
		response.setContentType("text/html");
		BusDAO busDAO = new BusDAO();
		out.println("<html>");
		int status = busDAO.removeBus(bId);
		if( status != 0){

			out.println("Deletion Successful");
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
			dispatcher.include(request, response);
		}else{
			out.println("Deletion Unsuccessful");
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
			dispatcher.include(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
