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
 * Servlet implementation class Password
 */
public class Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String pass = request.getParameter("code");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","root");
			PreparedStatement stmt = con.prepareStatement("UPDATE login SET passcode= ? WHERE username = 'admin';"); 
			stmt.setString(1, pass);
			stmt.execute();
			stmt.close();
			con.close();
			pw.println("<h4> PASSWORD CHANGED SUCCESFULLY </h4>");			
		}catch(Exception e) {System.err.println(e);
		pw.print("<center><h2>OOPS! SOMETHING WENT WRONG</h2>\r\n"
				+ "  </br></br>\r\n"
				+ "<h3>NOTE</h3>\r\n"
				+ "<h5>1.PASSWORD LENGTH MUST BE LESS THAN 20 CHARACTERS</h5>\r\n"
				+ "</center>");
		}
		
		pw.print("<h2>CLICK HERE TO <a href = \"admintodo.html\">GO BACK</a></h2>");
	}

}
