package com.ts.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.PassengerDAO;
import com.ts.dto.Passenger;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String pName=request.getParameter("pName");
		String password=request.getParameter("password");
		
		HttpSession session=request.getSession();
		session.setAttribute("pName", pName);
		session.setAttribute("password", password);
		
		
		response.setContentType("text/html");
		
		PassengerDAO passengerDao = new PassengerDAO();
		Passenger passenger = passengerDao.getPassenger(pName, password);
		System.out.println("Inside servlet:"+passenger);
		out.println("<html>");
		if(pName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
			RequestDispatcher dispatcher=request.getRequestDispatcher("Admin");	
				dispatcher.forward(request, response);
					}else if(passenger !=null){
			RequestDispatcher dispatcher=request.getRequestDispatcher("LoginHomePage.jsp");	
					dispatcher.forward(request, response);			
					}
					else{
				out.println("<body bgcolor=yellow text=red> Invalid credentials.!</body>");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.html"); 
					dispatcher.include(request, response);		
					}
					out.println("</html>");
				
}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}