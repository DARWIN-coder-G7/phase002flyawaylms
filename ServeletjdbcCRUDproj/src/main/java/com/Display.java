package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Display() {
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
	 ResultSet	rs=stmt.executeQuery("select * from flightdetails");
	 out.println("<table border=1 width=70% height=70%>"); 
	 out.println("<h1> MASTER LIST </h1>");
     out.println("<tr><th>FLIGHT ID</th><th>FLIGHT NAME</th><th>FROM</th><th>TO</th><th>PRICE</th></tr>");
	 while(rs.next())
	 {
	 out.println("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)+"</br>DATE : "+rs.getString(4)+"</br>TIME : "+rs.getString(5)+ "</td><td>" + rs.getString(6)+"</br>DATE : "+rs.getString(7)+"</br>TIME : "+rs.getString(8) + "</td><td>" + rs.getString(9)+ "</td></tr>");   
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

