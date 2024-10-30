package com.ts.web;

import java.io.IOException;
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

@WebServlet("/Add")
public class Add extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String bId=request.getParameter("bId");
		String seats = request.getParameter("seats");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String driverName=request.getParameter("driverName");
		long driverNumber=Long.parseLong(request.getParameter("driverNumber"));
		String time=request.getParameter("time");
		int price=Integer.parseInt(request.getParameter("price"));
		String doj = request.getParameter("doj");
		//System.out.println(doj);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = sdf.parse(doj);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		Bus bus=new Bus();
		bus.setbId(bId);
		bus.setSeats(Integer.parseInt(seats));
		bus.setSource(source);
		bus.setDestination(destination);
		bus.setDriverName(driverName);
		bus.setDriverNumber(driverNumber);
		bus.setDate(date);
		bus.setTime(time);
		bus.setPrice(price);
		
		System.out.println(bus);
		BusDAO busDAO = new BusDAO();
		if(busDAO.add(bus)!=0){
		System.out.println("hellos");
		response.getWriter().println("<h4>Added Success</h4>");
		RequestDispatcher dispatcher=request.getRequestDispatcher("admin.jsp");
		dispatcher.include(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
