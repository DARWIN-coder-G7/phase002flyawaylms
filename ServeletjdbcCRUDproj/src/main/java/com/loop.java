package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loop
 */
public class loop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loop() {
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
		out.println("<html><head>\r\n"
				+ "<style>\r\n"
				+ "body {\r\n"
				+ "  background-image: url('https://c4.wallpaperflare.com/wallpaper/171/914/407/animals-digital-art-pumas-minimalism-wallpaper-preview.jpg');\r\n"
				+ "  background-repeat: no-repeat;\r\n"
				+ "  background-attachment: fixed; \r\n"
				+ "  background-size: 100% 100%;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head><body>");

		String pcount =(String)session.getAttribute("pcount");
		int percount = Integer.parseInt(pcount);
		
	

		int i =1;
		if(i< percount) {
			out.print("<center>");
			out.println("<a href = \"regentry.html\">CLICK HERE TO ENTER THE DETAILS OF NEXT PERSON</a>");i++;
			out.println("</br></br></br>");
			out.println("<a href = \"ticketpriceconfirm\">CLICK HERE TO BOOK TICKET</a>");
			out.print("</br></br><h4>ENJOY THE WORLD'S FASTEST TRAVEL WITH US</h4>\r\n"
					+ "");
			out.print("</center>");
			out.print("</body></html>");
		}else {RequestDispatcher rd=request.getRequestDispatcher("ticketpriceconfirm");  
        rd.forward(request, response);  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
