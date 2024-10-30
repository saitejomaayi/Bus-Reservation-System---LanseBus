package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.BusDAO;
import com.ts.dto.Bus;

@WebServlet("/ViewSeats")
public class ViewSeats extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusDAO busDao = new BusDAO();
		PrintWriter out=response.getWriter();
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String doj = request.getParameter("doj");
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		
		HttpSession session=request.getSession();
		session.setAttribute("source", source);
		session.setAttribute("destination", destination);
		session.setAttribute("date", doj);
		
		
		try {
			System.out.println(doj);
			date = sdf.parse(doj);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Bus bus = busDao.getBusDetails(source, destination, date);
		System.out.println("Inside view seATS.JAVA"+bus);
		ArrayList<Bus> busesList = new ArrayList<Bus>();  
		RequestDispatcher dispatcher=request.getRequestDispatcher("UserPanel.jsp");
		request.setAttribute("bus", bus);
		session.setAttribute("bus", bus);
		dispatcher.forward(request, response);
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
