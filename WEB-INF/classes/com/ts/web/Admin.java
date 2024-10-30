package com.ts.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.BusDAO;
import com.ts.dto.Bus;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusDAO busDao = new BusDAO();
		List<Bus> busList=busDao.getAllBusDetails();
		System.out.println(busList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("admin.jsp");
		request.setAttribute("busList", busList);
		dispatcher.forward(request, response);
		
}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
