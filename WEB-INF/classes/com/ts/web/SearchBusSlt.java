package com.ts.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.BusDAO;
import com.ts.dto.Bus;

@WebServlet("/SearchBusSlt")
public class SearchBusSlt extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Bus bus = new Bus();
		PrintWriter out=response.getWriter();
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String doj = request.getParameter("doj");
		System.out.println("Inside doi=j"+doj);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("source", source);
		session.setAttribute("destination", destination);
		session.setAttribute("date", doj);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = sdf.parse(doj);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		
		BusDAO busDao = new BusDAO();
		bus = busDao.getBusDetails(source, destination, date);
		System.out.println("Inside servlet:"+bus);
		RequestDispatcher dispatcher=request.getRequestDispatcher("UserPanel.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}