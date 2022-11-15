package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class forward
 */
public class forward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession(false);
		 PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");

		int full = Integer.parseInt(request.getParameter("ticket"));
		String pcount =(String)session.getAttribute("pcount");
		int percount = Integer.parseInt(pcount);
		System.out.println("ticket id for price"+full);
		System.out.println("persons count at forward.java"+percount);
		
		ArrayList<Integer> priceof=new ArrayList<Integer>(); 
		priceof = (ArrayList<Integer>) request.getSession().getAttribute("ticketprice");
	   int size = priceof.size();
		if( full<= size) {
		if(full != 0) {
			int m = full-1;
			int result = percount * priceof.get(m);
			System.out.println(result);
			String s=String.valueOf(result);
			session.setAttribute("amount", s);
			System.out.println("result is"+result);
	     RequestDispatcher rd=request.getRequestDispatcher("regentry.html");  
	     rd.forward(request, response);  
	        out.println(result);
	        

		}
		}
		else
		System.out.println("select valid flight no");
		out.println("<center><h2>OOPS! SOMETHING WENT WRONG</h2>\r\n"
				+ "  </br></br>\r\n"
				+ "<h3>NOTE</h3>\r\n"
				+ "<h5 style = \"color:red;\">1.PLEASE SELECT A VALID FLIGHT NUMBER</h5>\r\n"
				+ "</center>");
		out.println("</body></html>");
		out.print("<h2>CLICK HERE TO <a href = \"useentry.html\">GO BACK</a></h2>");
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
