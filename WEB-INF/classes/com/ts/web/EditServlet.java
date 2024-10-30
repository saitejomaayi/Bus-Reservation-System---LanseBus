package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.BusDAO;
import com.ts.dto.Bus;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		String bId = request.getParameter("bus_id");	
		//Bus bus = new BusDAO().getBus(bId);
		BusDAO bd = new BusDAO();
		Bus bus = new Bus();
		bus = bd.getBus(bId);
			request.setAttribute("busData", bus);			
RequestDispatcher rd = request.getRequestDispatcher("editBusDetails.jsp");
			rd.forward(request, response);
			
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}
}