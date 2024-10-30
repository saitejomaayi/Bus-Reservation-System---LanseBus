package com.ts.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.PassengerDAO;
import com.ts.dto.Passenger;

@WebServlet("/RegisterSlt")
public class RegisterSlt extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String pId=request.getParameter("pId");
		String pName=request.getParameter("pName");
		String gender=request.getParameter("gender");
		int age=Integer.parseInt(request.getParameter("age"));
		long phone=Long.parseLong(request.getParameter("phone"));
		String password = request.getParameter("password");
		
		
		Passenger passenger=new Passenger();
		passenger.setpId(pId);
		passenger.setpName(pName);
		passenger.setGender(gender);
		passenger.setAge(age);
		passenger.setPhone(phone);
		passenger.setPassword(password);
		
		System.out.println(passenger);
		PassengerDAO passengerDAO = new PassengerDAO();
		if(passengerDAO.add(passenger)!=0){
		System.out.println("hellos");
		response.getWriter().println("<h1>Registration Success</h1>");
		RequestDispatcher dispatcher=request.getRequestDispatcher("Sample.html");
		dispatcher.include(request, response);
	
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
