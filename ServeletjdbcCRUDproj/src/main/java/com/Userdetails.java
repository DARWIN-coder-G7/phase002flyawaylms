package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Userdetails
 */
public class Userdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession(false);
			PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String cname = request.getParameter("country");
		String phone = request.getParameter("phone");
		String pport = request.getParameter("passport");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String gender = request.getParameter("GENDER");
		String purpose = request.getParameter("purpose");
		System.out.println(uname);
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","root");
			PreparedStatement stmt=con.prepareStatement("insert into userdetails(uname,cname,phoneNumber,pport,age,address,gender,purpose) values(?,?,?,?,?,?,?,?);");					
			stmt.setString(1,uname);
			stmt.setString(2,cname);
			stmt.setString(3,phone);
			stmt.setString(4,pport);
			stmt.setString(5,age);
			stmt.setString(6,address);
			stmt.setString(7,gender);
			stmt.setString(8,purpose);
			
		        session.setAttribute("uphone",phone);
			stmt.execute();
			stmt.close();
			con.close();
			RequestDispatcher rd=request.getRequestDispatcher("loop");  
	        rd.forward(request, response);
			System.out.println();
			System.out.println();
			System.out.println("DATA INSERTED SUCESSFULLY");
		
		}catch(Exception e) {System.err.println(e);}
			  
		out.print("click here to goto <a href = 'addflights.html' >goback</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
