package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.BusDAO;
import com.ts.dto.Bus;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private Connection con = null;
	private PreparedStatement pst = null;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();			
		String bId = request.getParameter("bId");
		int seats = Integer.parseInt(request.getParameter("seats"));
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String driverName = request.getParameter("driverName");
		long driverNumber = Long.parseLong(request.getParameter("driverNumber"));
		String time = request.getParameter("time");
		int price = Integer.parseInt(request.getParameter("price"));
		
		String doj = request.getParameter("doj");
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = sdf.parse(doj);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		BusDAO busDAO = new BusDAO();
		Bus bus=new Bus();
		bus.setbId(bId);
		bus.setSeats(seats);
		bus.setSource(source);
		bus.setDestination(destination);
		bus.setDriverName(driverName);
		bus.setDriverNumber(driverNumber);
		bus.setDate(date);
		bus.setTime(time);
		bus.setPrice(price);
		
		System.out.println(bus);
		int x = busDAO.updateBus(bus);
		if(x > 0) {											
			RequestDispatcher rd = request.getRequestDispatcher("Admin");
			rd.include(request, response);
			out.println("<center><h1>Update Successful...</h1><center>");			
		}
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}
}