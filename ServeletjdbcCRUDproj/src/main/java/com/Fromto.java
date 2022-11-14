package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fromto
 */
public class Fromto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fromto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 response.setContentType("text/html");  
       out.println("<html><body>"); 
	System.out.println();
		try {
			Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","root");
		Statement stmt=con.createStatement();
	 ResultSet	rs=stmt.executeQuery("SELECT departs_from,arrives_at,flight_name FROM flightdetails;");
	 out.println("<table border=1 width=50% height=50%>"); 
	 out.println("<h1> FLYAWAY SEVICES UPTO </h1>");
   out.println("<tr><th>FROM</th><th>TO</th><th>FLIGHT NAME</th></tr>");
	 while(rs.next())
	 {
	 out.println("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) +"</td><td>"+ rs.getString(3) + "</td></tr>");   
  out.print("<br>");
		 
	 }
	 out.println("</table>");  
   out.println("</html></body>");
	 out.print("Click here to  <a href='admintodo.html'>GO BACK </a>");
		stmt.close();
		con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	}


