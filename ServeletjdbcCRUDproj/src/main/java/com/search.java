package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class search
 */
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType ("text/html");
	        PrintWriter out = response.getWriter ();
	        String from = request.getParameter ("from");
	        String toto = request.getParameter ("to");
	    	ArrayList<String> al=new ArrayList<String>(); 
	    	ArrayList all=new ArrayList(); 
	       // String dadate = request.getParameter ("adate");
	        try
	        {
	            Class.forName ("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/flyaway", "root", "root");
	            PreparedStatement ps =
	         con.prepareStatement ("select * from flightdetails where (departs_from , arrives_at )=(?,?);");
	            ps.setString (1, from);
	            ps.setString (2, toto);
	           // ps.setString (3, dadate);
	            out.print ("<table width=50% border=1>");
	            out.print ("<caption>Employee Details:</caption>");
	            ResultSet rs = ps.executeQuery ();
	            while(rs.next()) {
	            	al.add(rs.getString(1));al.add(rs.getString(2));
	            	al.add(rs.getString(3));al.add(rs.getString(4));
	            	al.add(rs.getString(5));al.add(rs.getString(6));
	            	al.add(rs.getString(7));al.add(rs.getString(8));al.add(rs.getString(9));
	            	all.add(al);
	            }
	            //out.print(all.get(0));
	         /* Printing column names */
	         //   out.print ("</br></br>");
	           // ResultSetMetaData rsmd = rs.getMetaData ();
	            //int total = rsmd.getColumnCount ();
	          //  out.print ("<tr>");
	            //for (int i = 1; i <= total; i++)
	         //{
	           //  out.print ("<th>" + rsmd.getColumnName (i) + "</th>");
	         //}
	           // out.print ("</tr>");
	            /* Printing result */
	            int k = 0;
	           for (int i = 0; i < al.size();i++) 
	  	      { 		      
	  	          out.println(al.get(i));out.println("<input type = 'submit'value = "+k+">"); out.println("</br>");	k++;	
	  	      }
	          //  while (rs.next ())
	         //{
	           //  out.print ("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)+"</br>DATE : "+rs.getString(4)+"</br>TIME : "+rs.getString(5)+ "</td><td>" + rs.getString(6)+"</br>DATE : "+rs.getString(7)+"</br>TIME : "+rs.getString(8) + "</td><td>" + rs.getString(9)+ "</td></tr>");
	         //}
	            out.print ("</table>");
	        }
	        catch (Exception e2)
	        {
	            e2.printStackTrace ();
	        }
	        finally
	        {
	            out.close ();
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
