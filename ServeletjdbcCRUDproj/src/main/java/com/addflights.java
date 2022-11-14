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
 * Servlet implementation class addflights
 */
public class addflights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addflights() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		String fid = request.getParameter("flight_no");
		String fname = request.getParameter("flight_name");
		String from = request.getParameter("departs_from");
		String date = request.getParameter("ason");
		String time = request.getParameter("asat");
		String to = request.getParameter("arrives_at");
		String adate = request.getParameter("landon");
	String atime = request.getParameter("landat");
		String price = request.getParameter("price");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","root");
			PreparedStatement stmt=con.prepareStatement("insert into flightdetails values(?,?,?,?,?,?,?,?,?)");					
			stmt.setString(1,fid);
			stmt.setString(2,fname);
			stmt.setString(3,from);
			stmt.setString(4,date);
			stmt.setString(5,time);
			stmt.setString(6,to);
			stmt.setString(7,adate);
			stmt.setString(8,atime);
			stmt.setString(9,price);
			stmt.execute();
			stmt.close();
			con.close();
			System.out.println(time);
			System.out.println(atime);
			System.out.println("DATA INSERTED SUCESSFULLY");
		}catch(Exception e) {System.err.println(e);
		out.println("<center><h2>OOPS! SOMETHING WENT WRONG</h2>\r\n"
				+ "  </br></br>\r\n"
				+ "<h3>NOTE</h3>\r\n"
				+ "<h5>1.FLIGHT ID NEED TO BE UNIQUE</h5>\r\n"
				+ "</center>");
		}
		out.print("<h3>FLIGHT DETAILS ADDED SUCESSFULLY</h3>");
		out.print("</br></br>");
		out.print("<h2>CLICK HERE TO <a href = \"admintodo.html\">GO BACK</a></h2>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
