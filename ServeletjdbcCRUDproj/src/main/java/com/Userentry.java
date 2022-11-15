package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Userentry
 */
public class Userentry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userentry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String froom = request.getParameter("from");
		String tooo = request.getParameter("to");
		String date = request.getParameter("adate");
		String count = request.getParameter("count");
		System.out.println(date);
		System.out.println(froom);
		System.out.println(tooo);
		System.out.println(count);
		int i=0;
		int k =1;
		ArrayList<Integer> al=new ArrayList<Integer>(); 
		ArrayList<Integer> price=new ArrayList<Integer>(); 
		 HttpSession session=request.getSession();
		 session.setAttribute("pcount", count);
		response.setContentType("text/html");
		//out.println("<html><body>");
		 out.println("<html> <head>\r\n"
				+ "<style>\r\n"
				+ "body {\r\n"
				+ "  background-image: url('https://c4.wallpaperflare.com/wallpaper/197/17/282/windows-vista-microsoft-windows-operating-system-wallpaper-preview.jpg');\r\n"
				+ "  background-repeat: no-repeat;\r\n"
				+ "  background-attachment: fixed; \r\n"
				+ "  background-size: 100% 100%;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>"); 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway","root","root");
			PreparedStatement stmt=con.prepareStatement("select flight_name,departs_from,ason,asat,arrives_at,landon,landat,ticket_price from flightdetails where (departs_from , arrives_at , ason ) =(?,?,?);");	
			stmt.setString(1,froom);
			stmt.setString(2,tooo);
			stmt.setString(3,date);
			ResultSet	rs=stmt.executeQuery();
			
			 out.println("<table border=1 width=70% height=70%>"); 
			 out.println("<h1> YOUR SEARCH RESULT </h1>");
		     out.println("<tr><th>FLIGHT NO</th><th>FLIGHT NAME</th><th>FROM</th><th>TO</th><th>PRICE</th></tr>");
		     if (!rs.isBeforeFirst() ) {    
		    	    out.println("<h5 style = \"color:red;\">SORRY CURRENTLY NO FLIGHTS AVAILABLE </h5>\r\n"
		    	    		+ "</center>"); 
		    	}
		     else { while(rs.next())
			 {
				
			 out.println("<tr><td>" + k + "</td><td>" + rs.getString(1)+"</td><td>"+rs.getString(2)+"</br>DATE : "+rs.getString(3)+"</br>TIME : "+rs.getString(4)+ "</td><td>" + rs.getString(5)+"</br>DATE : "+rs.getString(6)+"</br>TIME : "+rs.getString(7) + "</td><td>" + rs.getString(8)+ "</td></tr>");   
		    out.print("<br>");
		   
		    int tickprice=Integer.parseInt(rs.getString(8));
		    price.add(i,tickprice);
		     i++;k++;
			 }}
			
			 session.setAttribute("ticketprice", price);
			 out.println("</table>");  
		     out.println("</html></body>");	
			out.println("</table>"); 
            out.println("<form action = \"forward\">\r\n"
		+ "<label>ENTER FLIGHT NO</label>\r\n"
		+ "<input type = \"number\" name = \"ticket\" required>\r\n"
		+ "  <input type = \"submit\" value =\"BOOK TICKET\">\r\n"
		+ "  </form>");	 
		    out.println("</html></body>");
			out.print("Click here to  <a href='useentry.html'>GO BACK </a>");
				stmt.close();
				con.close();
		       }catch(Exception e) {System.err.println(e);
            out.println("<center><h2>OOPS! SOMETHING WENT WRONG</h2>\r\n"
		     + "  </br></br>\r\n"
		     + "<h3>NOTE</h3>\r\n"
		     + "<h5 style = \"color:red;\">SORRY CURRENTLY NO FLIGHTS AVAILABLE </h5>\r\n"
		     + "</center>");
            out.print("<h2>CLICK HERE TO <a href = \"useentry.html\">GO BACK</a></h2>");
		}
	}

	

}
