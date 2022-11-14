package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flight_id=request.getParameter("flight_id");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","root");
		PreparedStatement stmt=con.prepareStatement("delete from flightdetails where flight_id=?");		
		stmt.setString(1, flight_id);
		stmt.execute();
		stmt.close();
		con.close();
		System.out.println("Data Deleted  Succsfully...!");
		} catch (Exception e) {
			System.err.println(e);
			out.print("<center><h2>OOPS! SOMETHING WENT WRONG</h2>\n"
					+ "  </br></br>\n"
					+ "<h3>NOTE</h3>\n"
					+ "<h5>1.CHECK THE FLIGHT YOU ENTERED</h5>\n"
					+ "</center>");
		}
	
		out.println("<h1>FLIGHT DETAILS DELETED SUCESSFULLY</h1>");
		out.print("</br></br></br>");
		out.print("<h2>CLICK HERE TO <a href = \"admintodo.html\">GO BACK</a></h2>");
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
